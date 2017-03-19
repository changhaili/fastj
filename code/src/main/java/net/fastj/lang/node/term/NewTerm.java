package net.fastj.lang.node.term;

import java.lang.reflect.Modifier;

import net.fastj.CompileException;
import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.InvokeUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.KlassNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class NewTerm extends AbstractLangNode {

	private final String className;

	private final LangNode[] args;

	public NewTerm(SourceInfo source, String className, LangNode[] args) {

		super(source);

		this.className = className;
		this.args = args;

		for (LangNode node : args) {
			node.setParent(this);
		}
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		for (int i = 0; i < this.args.length; i++) {
			this.args[i] = LangUtils.optimize(this.args[i], context);
		}

		return this.optimizes(context, this.args);
	}

	@Override
	public Result doEval(MModelContext context) {

		Object klass = context.getValue(className);

		if (klass instanceof KlassNode) {

			Object[] args = LangUtils.evalValues(context, this.args);
			return new ConstResult(((KlassNode) klass).createObject(context, args));

		}

		Class<?> cls = context.forClass(className);

		if (cls == null) {
			throw new LangException("'" + className + "' is not found");
		}

		if (cls.isInterface()) {
			throw new CompileException(this.source, "canot not new an interface '" + className + "'");
		}

		if ((cls.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT) {
			throw new CompileException(this.source, "canot not new an abstract class '" + className + "'");
		}

		Object[] args = LangUtils.evalValues(context, this.args);

		return InvokeUtils.invokeConstructor(cls, context, args);

	}

}
