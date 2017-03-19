package net.fastj.lang;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.term.ConstTerm;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.CustomerResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.DynamicFieldResult;

public class LangUtils {

	public final static ClassLoader CLASS_LOADER = LangUtils.class.getClassLoader();

	public static boolean isOptimizable(LangNode node) {
		return node instanceof ConstTerm;
	}

	public static LangNode optimize(LangNode node, MModelContext context) {
		return node.optimize(context);
	}

	public static Result eval(Object v, MModelContext context) {

		if (v == null) {
			return ConstResult.NULL;
		}

		if (v instanceof Result) {
			return (Result) v;
		} else if (v instanceof LangNode) {
			return ((LangNode) v).eval(context);
		} else {
			return new ConstResult(v);
		}
	}

	public static LangNode wrap(Object v) {
		return (v instanceof LangNode) ? (LangNode) v : new ConstTerm(null, v);
	}

	public static Result[] evalVariables(Object[] vs, MModelContext context) {

		if (vs == null)
			return null;

		Result[] values = new Result[vs.length];
		for (int i = 0; i < vs.length; i++) {
			values[i] = eval(vs[i], context);
		}
		return values;
	}

	public static Object[] evalValues(MModelContext context, Object[] vs) {

		if (vs == null)
			return null;

		Object[] values = new Object[vs.length];
		for (int i = 0; i < vs.length; i++) {

			if (vs[i] instanceof Result) {
				values[i] = LangUtils.toValue(((Result) vs[i]));
			} else if (vs[i] instanceof LangNode) {
				values[i] = LangUtils.toValue(((LangNode) vs[i]).eval(context));
			} else {
				values[i] = vs[i];
			}
		}
		return values;
	}

	public static Object toValue(Object value) {

		Object v = value;

		while (v instanceof Result) {
			v = ((Result) v).get();
		}

		return v;
	}

	public static Object toValue(LangNode node, MModelContext context) {

		Result v = eval(node, context);
		return v.get();
	}

	private static boolean checkInKlassNotFunction(LangNode node) {

		while (node != null) {

			if (node instanceof FunctionNode) {
				return false;
			}
			if (node instanceof KlassNode) {
				return true;
			}

			node = node.getParent();
		}

		return false;
	}

	public static Result assignCustumer(LangNode node, MModelContext context, String name, Object v) {

		if (LangUtils.checkInKlassNotFunction(node)) {

			DynamicObject obj = (DynamicObject) (context.getValue("this"));
			obj.setField(name, v);

			return new DynamicFieldResult(obj, name);

		} else {
			context.defineCustomer(name, v);
			return new CustomerResult(context, name);
		}

	}

}
