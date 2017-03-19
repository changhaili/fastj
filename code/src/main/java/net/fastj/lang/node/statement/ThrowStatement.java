package net.fastj.lang.node.statement;

import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class ThrowStatement extends AbstractLangNode {

	private LangNode exception;

	public ThrowStatement(SourceInfo source, LangNode exception) {

		super(source);
		this.exception = exception;

		this.exception.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.exception = LangUtils.optimize(this.exception, context);
		return this;
	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = LangUtils.eval(this.exception, context);
		throw new LangException((Exception) v.get());
	}	

}
