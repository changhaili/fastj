package net.fastj.lang.node;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.fastj.CompileException;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class KlassNode extends AbstractLangNode {

	protected final String name;

	protected final String[] supers;

	protected final LangNode[] segments;

	protected final FunctionNode[] functions;

	protected final Map<String, FunctionNode> _AllFunctions = new ConcurrentHashMap<String, FunctionNode>();

	private volatile boolean hasInitialized = false;

	public KlassNode(SourceInfo source, String name, String[] supers, LangNode[] segments, FunctionNode[] functions) {

		super(source);

		this.name = name;
		this.supers = supers;

		this.segments = segments;
		this.functions = functions;

		for (LangNode segment : segments) {
			segment.setParent(this);
		}

		for (FunctionNode function : functions) {
			function.setParent(this);
		}

	}

	public void fillObject(DynamicObject obj, MModelContext context, Object[] args) {

		if (!hasInitialized) {

			synchronized (this._AllFunctions) {

				for (int i = this.supers.length; i > 0; i--) {

					Object superKlass = context.getValue(this.supers[i - 1]);
					if (!(superKlass instanceof KlassNode)) {
						throw new CompileException(this.source, "super must be a class!");
					}

					this._AllFunctions.putAll(((KlassNode) superKlass)._AllFunctions);

				}

				for (FunctionNode fun : this.functions) {
					this._AllFunctions.put(fun.getName(), fun);
				}
			}
			hasInitialized = true;
		}

		for (int i = this.supers.length; i > 0; i--) {

			Object superKlass = context.getValue(this.supers[i - 1]);
			if (!(superKlass instanceof KlassNode)) {
				throw new CompileException(this.source, "super must be a class!");
			}

			((KlassNode) superKlass).fillObject(obj, context, args);

		}

		context.putConstants("__CLASS__", this.name);
		context.putConstants("this", obj);

		for (LangNode segment : this.segments) {
			LangUtils.eval(segment, context);
		}

		if (obj.isFunction(this.name)) {
			obj.invokeFunction(this.name, context, args);
		}
	}

	public DynamicObject createObject(MModelContext context, Object[] args) {

		DynamicObject obj = new DynamicObject(this._AllFunctions, this);

		this.fillObject(obj, context, args);
		return obj;
	}

	@Override
	protected Result doEval(MModelContext context) {

		context.putConstants(this.name, this);
		return new ConstResult(this);
	}

}
