package net.fastj.lang.node.segment;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.BreakResult;
import net.fastj.lang.result.ContinueResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class DoWhileSegment extends AbstractLoopSegment {

	private final String label;

	private LangNode condition;

	private LangNode segment;

	public DoWhileSegment(SourceInfo source, String label, LangNode condition, LangNode segment) {

		super(source);

		this.label = label;
		this.condition = condition;
		this.segment = segment;

		this.condition.setParent(this);

		if (this.segment != null)
			this.segment.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.condition = LangUtils.optimize(this.condition, context);
		this.segment = LangUtils.optimize(this.segment, context);

		return this.optimizes(context, this.condition, this.segment);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = null;
		do {

			try {

				context.enterBlock();

				v = LangUtils.eval(this.segment, context);

				if (v instanceof BreakResult) {

					String label = ((BreakResult) v).getLabel();
					if (StringUtils.isBlank(this.label) || !StringUtils.equals(label, this.label)) {
						break;
					}
				}

				if (v instanceof ContinueResult) {
					continue;
				}

				if (v instanceof ReturnResult) {
					return v;
				}

				boolean condition = (Boolean) ConvertUtils.convert(LangUtils.eval(this.condition, context),
						Boolean.class);

				if (!condition) {
					break;
				}
			} finally {
				context.leaveBlock();
			}

		} while (true);

		return v;
	}
}
