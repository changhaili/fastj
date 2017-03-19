package net.fastj.lang.node.segment;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class StatementSegment extends AbstractSegment {

	private LangNode stmt;

	public StatementSegment(SourceInfo source, LangNode stmt) {

		super(source);
		this.stmt = stmt;

		if (this.stmt != null)
			this.stmt.setParent(this);
	}

	@Override
	protected boolean hasBlock() {
		return false;
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.stmt = LangUtils.optimize(this.stmt, context);

		return this.optimizes(context, this.stmt);
	}

	@Override
	public Result doEval(MModelContext context) {
		return LangUtils.eval(this.stmt, context);
	}

}
