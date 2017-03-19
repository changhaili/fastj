package net.fastj.lang.result;

public class ExceptionResult extends TokenResult {

	private final Exception exception;

	public ExceptionResult(Exception exception) {
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}

	public void Rethrow() throws Exception {

		if (this.exception != null)
			throw this.exception;
	}

	public void throwAsRuntimeException() {

		if (this.exception != null)
			throw new RuntimeException(this.exception);
	}

	@Override
	public Object get() {
		this.throwAsRuntimeException();
		return null;
	}
}
