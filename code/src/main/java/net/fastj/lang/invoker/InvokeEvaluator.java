package net.fastj.lang.invoker;

import net.fastj.lang.mmodel.MModelContext;

public class InvokeEvaluator {

	protected Object parent;

	protected Class<?> declare;

	protected String methodName;

	public InvokeEvaluator(Object parent, Class<?> declare, String methodName) {

		this.parent = parent;
		this.declare = declare;
		this.methodName = methodName;
	}

	public MethodInvoker eval(MModelContext context) {
		return new MethodInvoker(this.parent, this.declare, this.methodName, context);
	}

}
