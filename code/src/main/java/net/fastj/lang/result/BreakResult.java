package net.fastj.lang.result;

public class BreakResult extends TokenResult {
	


	private final String label;

	public BreakResult(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
