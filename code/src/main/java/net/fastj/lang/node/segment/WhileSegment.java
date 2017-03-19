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

public class WhileSegment extends AbstractLoopSegment {

	private final String label;

	private LangNode condition;

	private LangNode segment;

	public WhileSegment(SourceInfo source, String label, LangNode condition, LangNode segment) {

		super(source);

		this.label = label;
		this.condition = condition;
		this.segment = segment;

		this.condition.setParent(this);

		if (this.segment != null)
			this.segment.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		this.condition = LangUtils.optimize(this.condition, datums);
		this.segment = LangUtils.optimize(this.segment, datums);

		return this.optimizes(datums, this.condition, this.segment);
	}

	@Override
	public Result doEval(MModelContext datums) {

		while (true) {

			try {
				datums.enterBlock();

				boolean condition = (Boolean) ConvertUtils
						.convert(LangUtils.eval(this.condition, datums).get(), Boolean.class);

				if (!condition) {
					break;
				}

				Result v = LangUtils.eval(this.segment, datums);

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
			} finally {
				datums.leaveBlock();
			}

		}

		return null;
	}
}
