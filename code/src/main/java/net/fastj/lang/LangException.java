package net.fastj.lang;

public class LangException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4731443639010651094L;

	public LangException() {

	}

	public LangException(Throwable cause) {
		super(cause);
	}

	public LangException(String message) {
		super(message);
	}

	public LangException(String message, Throwable cause) {
		super(message, cause);
	}

}
