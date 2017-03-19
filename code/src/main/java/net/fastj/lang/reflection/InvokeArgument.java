package net.fastj.lang.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.NotImplementedException;

public class InvokeArgument {

	private final Object proxy;

	private final Method method;

	private final Object[] args;

	private Method proxyMethod;

	public InvokeArgument(Object proxy, Method method, Object[] args) {

		this.proxy = proxy;
		this.method = method;
		this.args = args;

		try {
			proxyMethod = proxy.getClass().getMethod(ClassMaker.getSuperMethodName(method.getName()),
					method.getParameterTypes());
		} catch (NoSuchMethodException | SecurityException e) {
			proxyMethod = null;
		}
	}

	public Object getProxy() {
		return proxy;
	}

	public Method getMethod() {
		return method;
	}

	public Object[] getArgs() {
		return args;
	}

	public boolean isInvokable() {
		return this.proxyMethod != null;
	}

	public Object invoke() {

		if (proxyMethod == null)
			throw new NotImplementedException();

		try {
			return proxyMethod.invoke(this.proxy, this.args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}

	}

	public String getMethodName() {
		return this.method.getName();
	}
}
