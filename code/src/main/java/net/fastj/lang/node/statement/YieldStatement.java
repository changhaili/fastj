package net.fastj.lang.node.statement;

import net.fastj.CompileException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.node.segment.AbstractLoopSegment;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.YieldResult;

public class YieldStatement extends AbstractLangNode {

	private LangNode expr;

	public YieldStatement(SourceInfo source, LangNode expr) {

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

		Result v = LangUtils.eval(this.expr, context);

		LangNode p = this.parent;
		while (p != null) {
			if (p instanceof AbstractLoopSegment) {
				((AbstractLoopSegment) p).addYield(context, LangUtils.toValue(v));
				return YieldResult.INSTANCE;
			}

			p = p.getParent();
		}

		throw new CompileException(this.source, "yield must be in a loop block!");
	}

}
