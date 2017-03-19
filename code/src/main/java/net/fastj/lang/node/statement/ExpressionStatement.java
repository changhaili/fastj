package net.fastj.lang.node.statement;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class ExpressionStatement extends AbstractLangNode {

	private LangNode expr;

	public ExpressionStatement(SourceInfo source, LangNode expr) {

		super(source);
		this.expr = expr;
		
		this.expr.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.expr = LangUtils.optimize(this.expr, context);
		return this.optimizes(context, this.expr);
	}

	@Override
	public Result doEval(MModelContext context) {
		return LangUtils.eval(this.expr, context);
	}

}
