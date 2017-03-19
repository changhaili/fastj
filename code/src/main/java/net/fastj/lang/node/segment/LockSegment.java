package net.fastj.lang.node.segment;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class LockSegment extends AbstractSegment {

	private LangNode expr;

	private LangNode segment;

	public LockSegment(SourceInfo source, LangNode expr, LangNode segment) {
		super(source);

		this.expr = expr;
		this.segment = segment;
	}

	@Override
	protected LangNode doOptimize(MModelContext context) {

		this.expr = LangUtils.optimize(this.expr, context);
		this.segment = LangUtils.optimize(this.segment, context);

		return this.optimizes(context, this.expr, this.segment);
	}

	@Override
	protected Result doEval(MModelContext context) {

		Result obj = LangUtils.eval(this.expr, context);

		synchronized (obj.get()) {
			return LangUtils.eval(this.segment, context);
		}

	}

}
