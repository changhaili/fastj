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

public class ForSegment extends AbstractLoopSegment {

	private final String label;

	private LangNode expr0;

	private LangNode expr1;

	private LangNode expr2;

	private LangNode segment;

	public ForSegment(SourceInfo source, String label, LangNode expr0, LangNode expr1, LangNode expr2,
			LangNode segment) {

		super(source);

		this.label = label;
		this.expr0 = expr0;
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.segment = segment;

		if (this.expr0 != null)
			this.expr0.setParent(this);

		if (this.expr1 != null)
			this.expr1.setParent(this);

		if (this.expr2 != null)
			this.expr2.setParent(this);

		if (this.segment != null)
			this.segment.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		this.expr0 = LangUtils.optimize(this.expr0, datums);
		this.expr1 = LangUtils.optimize(this.expr1, datums);
		this.expr2 = LangUtils.optimize(this.expr2, datums);
		this.segment = LangUtils.optimize(this.segment, datums);

		return this.optimizes(datums, this.expr0, this.expr1, this.expr2, this.segment);
	}

	@Override
	public Result doEval(MModelContext datums) {

		LangUtils.eval(this.expr0, datums);

		while (true) {

			try {

				datums.enterBlock();

				if (this.expr1 != null) {

					Result v1 = LangUtils.eval(this.expr1, datums);

					if (!(Boolean) ConvertUtils.convert(v1.get(), Boolean.class)) {
						break;
					}
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
