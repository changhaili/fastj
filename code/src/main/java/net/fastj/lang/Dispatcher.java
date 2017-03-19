package net.fastj.lang;

import org.apache.commons.lang.StringUtils;

public class Dispatcher {

	protected final DynamicObject sender;

	protected final String function;

	protected final Object[] arguments;

	public Dispatcher(DynamicObject sender, String function, Object[] arguments) {

		this.sender = sender;
		this.function = function;
		this.arguments = arguments;
	}

	public String getFunction() {
		return function;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public boolean isBefore() {
		return false;
	}

	public boolean isAfter() {
		return false;
	}

	public boolean isException() {
		return false;
	}

	public boolean isInvoke() {
		return false;
	}

	public static class Before extends Dispatcher {

		@Override
		public boolean isBefore() {
			return true;
		}

		public Before(DynamicObject sender, String function, Object[] arguments) {
			super(sender, function, arguments);
		}

		@Override
		public String toString() {
			return "before invoke : " + this.function + ", args :" + StringUtils.join(this.arguments, ",");
		}

	}

	public static class After extends Dispatcher {

		private final Object result;

		public Object getResult() {
			return result;
		}

		@Override
		public boolean isAfter() {
			return true;
		}

		public After(DynamicObject sender, String function, Object[] arguments, Object result) {
			super(sender, function, arguments);

			this.result = result;
		}

		@Override
		public String toString() {
			return "after invoke : " + this.function + "; args :"
					+ StringUtils.join(this.arguments, "; result:" + this.result);
		}

	}

	public static class Exception extends Dispatcher {

		private final java.lang.Exception exception;

		public java.lang.Exception getException() {
			return exception;
		}

		@Override
		public boolean isException() {
			return true;
		}

		public Exception(DynamicObject sender, String function, Object[] arguments, java.lang.Exception exception) {
			super(sender, function, arguments);
			this.exception = exception;
		}

		@Override
		public String toString() {
			return "after invoke exception : " + this.function + "; args :"
					+ StringUtils.join(this.arguments, "; exception:" + this.exception);
		}

	}

	public static class Invoke extends Dispatcher {

		@Override
		public boolean isInvoke() {
			return true;
		}

		public Invoke(DynamicObject sender, String function, Object[] arguments) {
			super(sender, function, arguments);
		}

		@Override
		public String toString() {
			return "invoke : " + this.function + ", args :" + StringUtils.join(this.arguments, ",");
		}

	}

}
