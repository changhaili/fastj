package net.fastj.lang.node.statement;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ContinueResult;
import net.fastj.lang.result.Result;

public class ContinueStatement extends AbstractLangNode {

	public ContinueStatement(SourceInfo source) {
		super(source);
	}

	@Override
	public Result doEval(MModelContext context) {
		return ContinueResult.INSTANCE;
	}
}
