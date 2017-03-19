package net.fastj.lang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.fastj.collection.KeyValueGetter;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;

public class DynamicObject {

	private final ConcurrentHashMap<String, Object> fields = new ConcurrentHashMap<String, Object>();

	private final Map<String, FunctionNode> functions;

	private final KlassNode klass;

	public final static String TO_STRING = "toString";
	public final static String DISPATCH = "dispatch";

	public final static String HASH_CODE = "hashcode";
	public final static String EQUALS = "equals";
	public final static String GET_CLASS = "getClass";

	public DynamicObject(Map<String, FunctionNode> functions, KlassNode klass) {
		this.functions = functions;
		this.klass = klass;
	}

	public KlassNode getKlass() {
		return this.klass;
	}

	public boolean isField(String name) {
		return this.fields.containsKey(name);
	}

	public boolean isFunction(String name) {
		return this.functions.containsKey(name);
	}

	public Object getField(String fieldName) {
		return this.fields.get(fieldName);
	}

	public Object setField(String fieldName, Object value) {
		return this.fields.put(fieldName, value);
	}

	private Object invokeDispatch(MModelContext context, Dispatcher dispatcher) {

		if (this.isFunction(DISPATCH)) {
			return this.functions.get(DISPATCH).invoke(context, new Object[] { dispatcher }).get();
		}

		return null;
	}

	public Object invokeFunction(String functionName, MModelContext context, Object... args) {

		Object obj = null;
		try {
			this.invokeDispatch(context, new Dispatcher.Before(this, functionName, args));

			if (this.isFunction(functionName)) {

				obj = this.functions.get(functionName).invoke(context, args).get();
			} else {
				obj = this.invokeDispatch(context, new Dispatcher.Invoke(this, functionName, args));
			}
		} catch (Exception ex) {
			this.invokeDispatch(context, new Dispatcher.Exception(this, functionName, args, ex));
		} finally {
			this.invokeDispatch(context, new Dispatcher.After(this, functionName, args, obj));
		}

		return obj;

	}

	public static Object dispatch(DynamicObject v, MModelContext context, Object... args) {

		DynamicObject obj = (DynamicObject) v;
		if (obj.isFunction(DISPATCH)) {
			return "" + obj.invokeFunction(DISPATCH, context, args);
		}

		return null;
	}

	public static Object getClass(Object v, MModelContext datums, KeyValueGetter<String, Object> externals) {

		if (v instanceof DynamicObject) {
			DynamicObject obj = (DynamicObject) v;
			if (obj.isFunction(GET_CLASS)) {
				return obj.invokeFunction(GET_CLASS, datums, externals);
			} else {
				return obj.getKlass();
			}

		}

		return v.getClass();
	}

	public static String toString(Object v, MModelContext context) {

		if (v instanceof DynamicObject) {
			DynamicObject obj = (DynamicObject) v;
			if (obj.isFunction(TO_STRING)) {
				return "" + obj.invokeFunction(TO_STRING, context);
			}

		}

		return v.toString();
	}

	public static String[] toString(Object[] vs, MModelContext context) {

		if (vs == null)
			return null;

		String[] ss = new String[vs.length];
		for (int i = 0; i < vs.length; i++) {
			Object v = vs[i];
			if (v instanceof DynamicObject) {
				DynamicObject obj = (DynamicObject) v;
				if (obj.isFunction(TO_STRING)) {
					ss[i] = "" + obj.invokeFunction(TO_STRING, context);
					continue;
				}
			}

			ss[i] = v.toString();

		}

		return ss;
	}

	public static int hashcode(Object v, MModelContext datums, KeyValueGetter<String, Object> externals) {

		if (v instanceof DynamicObject) {
			DynamicObject obj = (DynamicObject) v;
			if (obj.isFunction(HASH_CODE)) {
				return (Integer) obj.invokeFunction(HASH_CODE, datums, externals);
			}

		}

		return v.hashCode();
	}

	public static boolean equals(Object v, MModelContext context, Object other) {

		if (v instanceof DynamicObject) {
			DynamicObject obj = (DynamicObject) v;
			if (obj.isFunction(HASH_CODE)) {
				return (Boolean) obj.invokeFunction(HASH_CODE, context, other);
			}
		}

		return v.equals(other);
	}

	@Override
	public String toString() {
		return "fields : { " + this.fields.toString() + " } , functions : { " + this.functions.keySet() + " } ";
	}

}
