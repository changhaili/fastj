package net.fastj.lang.node;

import org.antlr.v4.runtime.ParserRuleContext;

public class SourceInfo {

	private final ParserRuleContext context;

	private final NodeVisitor visitor;

	public SourceInfo(NodeVisitor visitor, ParserRuleContext context) {

		this.visitor = visitor;
		this.context = context;
	}

	public ParserRuleContext getContext() {
		return context;
	}

	public NodeVisitor getVisitor() {
		return visitor;
	}

	public int getStartLine() {
		if (this.context == null) {
			return -1;
		}
		if (this.context.start == null) {
			return -1;
		}
		return this.context.start.getLine();
	}

	public int getStopLine() {
		return this.context.stop.getLine();
	}

	public String getCode() {
		return this.context.getText();
	}

	@Override
	public String toString() {
		return this.getCode();
	}

}
