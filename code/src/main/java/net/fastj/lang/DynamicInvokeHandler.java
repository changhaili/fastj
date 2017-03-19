package net.fastj.lang;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.reflection.InvokeArgument;
import net.fastj.lang.reflection.InvokeHandler;

public class DynamicInvokeHandler extends InvokeHandler {

	private final MModelContext context;

	public final DynamicObject handler;

	public DynamicInvokeHandler(DynamicObject handler, MModelContext context) {
		this.handler = handler;
		this.context = context;
	}

	@Override
	public Object invoke(InvokeArgument arg) {

		if (handler.isFunction(arg.getMethodName())) {
			return handler.invokeFunction(arg.getMethodName(), context, arg.getArgs());
		} else if (arg.isInvokable()) {
			return arg.invoke();
		}
		return handler.invokeFunction(DynamicObject.DISPATCH, context, arg.getArgs());
	}

}
