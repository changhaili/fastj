package net.fastj.lang.invoker;

public class ProcessResult {

	public String input;
	public String error;

	public int code;

	ProcessResult(String input, String error, int code) {
		this.input = input;
		this.error = error;
		this.code = code;
	}

	@Override
	public String toString() {
		return this.input;
	}
}
