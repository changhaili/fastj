package net.fastj.lang.node.segment;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class TrySegment extends AbstractSegment {

	private LangNode[] trySegments;

	private String exceptionID;
	private LangNode[] catchSegments;
	private LangNode[] finallySegments;

	public TrySegment(SourceInfo source, LangNode[] trySegments, String exceptionID, LangNode[] catchSegments,
			LangNode[] finallySegments) {

		super(source);

		this.trySegments = trySegments;
		this.exceptionID = exceptionID;
		this.catchSegments = catchSegments;
		this.finallySegments = finallySegments;

		for (LangNode node : trySegments) {
			node.setParent(this);
		}

		for (LangNode node : catchSegments) {
			node.setParent(this);
		}

		for (LangNode node : finallySegments) {
			node.setParent(this);
		}
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		boolean optimizable = true;

		for (int i = 0; i < this.trySegments.length; i++) {
			this.trySegments[i] = LangUtils.optimize(this.trySegments[i], datums);

			if (optimizable && !LangUtils.isOptimizable(this.trySegments[i])) {
				optimizable = false;
			}

		}

		for (int i = 0; i < this.catchSegments.length; i++) {
			this.catchSegments[i] = LangUtils.optimize(this.catchSegments[i], datums);

			if (optimizable && !LangUtils.isOptimizable(this.catchSegments[i])) {
				optimizable = false;
			}
		}

		for (int i = 0; i < this.finallySegments.length; i++) {
			this.finallySegments[i] = LangUtils.optimize(this.finallySegments[i], datums);

			if (optimizable && !LangUtils.isOptimizable(this.finallySegments[i])) {
				optimizable = false;
			}
		}

		if (optimizable) {
			return this.optimize(datums);
		}

		return this;

	}

	@Override
	public Result doEval(MModelContext datums) {

		try {

			try {
				datums.enterBlock();

				if (this.trySegments != null) {

					for (LangNode segment : this.trySegments) {
						Result v = LangUtils.eval(segment, datums);
						if (v instanceof ReturnResult) {
							return v;
						}
					}
				}
			} finally {
				datums.leaveBlock();
			}

		} catch (Exception ex) {

			try {

				datums.enterBlock();

				datums.defineCustomer(exceptionID, ex);

				if (this.catchSegments != null) {

					for (LangNode segment : this.catchSegments) {
						Result v = LangUtils.eval(segment, datums);
						if (v instanceof ReturnResult) {
							return v;
						}
					}
				}
			} finally {
				datums.leaveBlock();
			}

		} finally {

			try {
				datums.enterBlock();

				if (this.finallySegments != null) {

					for (LangNode segment : this.finallySegments) {
						Result v = LangUtils.eval(segment, datums);
						if (v instanceof ReturnResult) {
							return v;
						}
					}
				}
			} finally {
				datums.leaveBlock();
			}

		}

		return null;
	}

}
