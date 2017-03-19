package net.fastj.lang.reflection;

import net.fastj.collection.KeyValueGetter;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.mmodel.MModelContext;

public class ProxyHandler extends InvokeHandler {

	private final MModelContext datums;
	private final KeyValueGetter<String, Object> externals;
	private final DynamicObject declare;

	public ProxyHandler(DynamicObject declare, MModelContext datums, KeyValueGetter<String, Object> externals) {

		this.datums = datums;
		this.externals = externals;
		this.declare = declare;
	}


	@Override
	public Object invoke(InvokeArgument arg) {

		if (declare.isFunction(arg.getMethodName())) {
			return declare.invokeFunction(arg.getMethodName(), datums, externals, arg.getArgs());
		} else if (arg.isInvokable()) {
			return arg.invoke();
		}
		return DynamicObject.dispatch(declare, datums, externals, arg.getArgs());
	}

}
