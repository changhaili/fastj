package net.fastj.lang.node.statement;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class ReturnStatement extends AbstractLangNode {

	private LangNode expr;

	public ReturnStatement(SourceInfo source, LangNode expr) {

		super(source);
		this.expr = expr;

		if (this.expr != null)
			this.expr.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		if (this.expr == null) {
			return this;
		}

		this.expr = LangUtils.optimize(this.expr, context);
		return this.optimizes(context, this.expr);
	}

	@Override
	public Result doEval(MModelContext context) {

		if (this.expr == null) {
			return ReturnResult.NULL;
		}

		Result v = LangUtils.eval(this.expr, context);

		return v instanceof ReturnResult ? (ReturnResult) v : new ReturnResult(v.get());
	}

}
