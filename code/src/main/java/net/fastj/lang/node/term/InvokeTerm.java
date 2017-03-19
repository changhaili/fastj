package net.fastj.lang.node.term;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.ArrayUtils;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.LamdbaFunObject;
import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.InvokeUtils;
import net.fastj.lang.invoker.OperatorInvoker;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.reflection.ClassMaker;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.IndexElementResult;
import net.fastj.lang.result.MapElementResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.DynamicFunctionResult;
import net.fastj.lang.result.klass.DynamicMemberResult;
import net.fastj.lang.result.klass.JavaFieldResult;
import net.fastj.lang.result.klass.JavaMemberResult;
import net.fastj.lang.result.klass.JavaMethodResult;

public class InvokeTerm extends AbstractLangNode {

	private LangNode function;

	private final LangNode[] args;

	private final boolean isIndex;

	public InvokeTerm(SourceInfo source, LangNode function, LangNode[] args, boolean isIndex) {

		super(source);

		this.function = function;
		this.args = args;
		this.isIndex = isIndex;

		this.function.setParent(this);

		for (LangNode node : args) {
			node.setParent(this);
		}
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.function = LangUtils.optimize(this.function, context);

		for (int i = 0; i < this.args.length; i++) {
			this.args[i] = LangUtils.optimize(this.args[i], context);
		}

		return this.optimizes(context, (LangNode[]) ArrayUtils.add(this.args, this.function));
	}

	@Override
	public Result doEval(MModelContext context) {

		if (this.isIndex) {
			return this.evalIndex(context);

		} else {
			return this.evalMethod(context);
		}
	}

	@SuppressWarnings("rawtypes")
	private Result evalIndex(MModelContext context) {

		Result obj = LangUtils.eval(this.function, context);

		Object v = obj.get();

		if (v instanceof DynamicObject) {

			return new ConstResult(
					((DynamicObject) v).invokeFunction("[]", context, LangUtils.evalValues(context, args)));

		} else if (v instanceof Map) {

			Result key = LangUtils.eval(this.args[this.args.length - 1], context);

			return new MapElementResult((Map) v, key.get());

		} else if (v instanceof Collection || v instanceof Enumeration || Reflections.isArray(v)) {

			Result key = LangUtils.eval(this.args[this.args.length - 1], context);
			int index = (Integer) ConvertUtils.convert(key.get(), Integer.class);

			return new IndexElementResult(v, index);

		} else if (v instanceof CharSequence) {
			Result key = LangUtils.eval(this.args[this.args.length - 1], context);

			int index = (Integer) ConvertUtils.convert(key.get(), Integer.class);
			return new ConstResult(((CharSequence) v).charAt(index));

		} else {

			return InvokeUtils.invokeMethod(v, v.getClass(), "[]", context, LangUtils.evalValues(context, args));

		}
	}

	private Result evalMethod(MModelContext context) {

		Result obj = LangUtils.eval(this.function, context);

		if (obj instanceof JavaMethodResult) {

			JavaMethodResult method = (JavaMethodResult) obj;
			return InvokeUtils.invokeMethod(method.getParent(), method.getDeclare(), method.getMethod(), context,
					LangUtils.evalValues(context, args));
		}
		if (obj instanceof DynamicFunctionResult) {

			DynamicFunctionResult fun = (DynamicFunctionResult) obj;

			return new ConstResult(
					fun.getParent().invokeFunction(fun.getName(), context, LangUtils.evalValues(context, args)));
		}

		if (obj instanceof DynamicMemberResult) {

			DynamicFunctionResult fun = (DynamicFunctionResult) ((DynamicMemberResult) obj).getFuntion();
			if (fun != null) {
				return new ConstResult(
						fun.getParent().invokeFunction(fun.getName(), context, LangUtils.evalValues(context, args)));
			}
		}

		if (obj instanceof JavaMemberResult) {

			JavaMemberResult members = (JavaMemberResult) obj;

			JavaMethodResult method = members.getMethod();

			if (method != null) {

				return InvokeUtils.invokeMethod(method.getParent(), method.getDeclare(), method.getMethod(), context,
						LangUtils.evalValues(context, args));

			}

			JavaFieldResult field = members.getField();
			if (field != null) {

				Object v = field.get();
				return InvokeUtils.invokeMethod(v, v.getClass(), "()", context, LangUtils.evalValues(context, args));
			}

		}

		Object v = LangUtils.toValue(obj);

		if (v instanceof FunctionNode) {
			return ((FunctionNode) v).invoke(context, LangUtils.evalValues(context, args));
		}

		if (v instanceof DynamicObject) {

			return new ConstResult(
					((DynamicObject) v).invokeFunction("()", context, LangUtils.evalValues(context, args)));
		}

		if (v instanceof LamdbaFunObject) {
			return new ConstResult(ClassMaker.invokeProxy(context, v, LangUtils.evalValues(context, args)));
		}

		return new OperatorInvoker(context, "()",
				ArrayUtils.addAll(new Object[] { v }, LangUtils.evalValues(context, args))).invoke();

	}

}
