package net.fastj.lang.node.statement;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.BreakResult;
import net.fastj.lang.result.Result;

public class BreakStatement extends AbstractLangNode {

	private final BreakResult result;

	public BreakStatement(SourceInfo source, String label) {
		super(source);

		result = new BreakResult(label);
	}

	@Override
	public Result doEval(MModelContext context) {
		return this.result;
	}

}
