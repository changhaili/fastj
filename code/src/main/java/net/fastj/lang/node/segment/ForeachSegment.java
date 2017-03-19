package net.fastj.lang.node.segment;

import org.apache.commons.lang.StringUtils;

import net.fastj.collection.Collections;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.BreakResult;
import net.fastj.lang.result.ContinueResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class ForeachSegment extends AbstractLoopSegment {

	private final String label;

	private final String variant;

	private LangNode collection;

	private LangNode segment;

	public ForeachSegment(SourceInfo source, String label, String variant, LangNode collection, LangNode segment) {

		super(source);

		this.label = label;
		this.variant = variant;
		this.collection = collection;
		this.segment = segment;

		this.collection.setParent(this);

		if (this.segment != null)
			this.segment.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		this.collection = LangUtils.optimize(this.collection, datums);
		this.segment = LangUtils.optimize(this.segment, datums);

		return this.optimizes(datums, this.collection, this.segment);
	}

	@Override
	public Result doEval(MModelContext datums) {

		Result cols = LangUtils.eval(this.collection, datums);

		Object[] array = Collections.toArray(cols.get());

		Result v = null;

		for (Object o : array) {

			try {

				datums.enterBlock();
				datums.defineCustomer(this.variant, o);

				v = LangUtils.eval(this.segment, datums);

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

		return v;
	}

}
