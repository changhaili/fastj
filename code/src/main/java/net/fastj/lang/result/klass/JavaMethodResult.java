package net.fastj.lang.result.klass;

import net.fastj.lang.result.TokenResult;

public class JavaMethodResult extends TokenResult {

	private final Object parent;

	private final Class<?> declare;

	private final String method;

	public JavaMethodResult(Object parent, Class<?> declare, String method) {

		this.parent = parent;
		this.declare = declare;
		this.method = method;
	}

	public Object getParent() {
		return this.parent;
	}

	public Class<?> getDeclare() {
		return this.declare;
	}

	public String getMethod() {
		return this.method;
	}

}
