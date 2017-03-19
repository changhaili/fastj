package net.fastj.lang.reflection;

public class InvokeHandler {

	public Object postInvoke(Object result, InvokeArgument arg) {
		return result;
	}

	public void preInvoke(InvokeArgument arg) {
	}

	public Object invoke(InvokeArgument arg) {
		return arg.invoke();
	}

}
