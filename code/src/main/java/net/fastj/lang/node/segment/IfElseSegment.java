package net.fastj.lang.node.segment;

import org.apache.commons.beanutils.ConvertUtils;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class IfElseSegment extends AbstractSegment {

	LangNode condition;

	LangNode ifSegment;

	LangNode elseSegment;

	public IfElseSegment(SourceInfo source, LangNode condition, LangNode ifSegment, LangNode elseSegment) {

		super(source);
		this.condition = condition;
		this.ifSegment = ifSegment;
		this.elseSegment = elseSegment;

		if (this.condition != null)
			this.condition.setParent(this);

		if (this.ifSegment != null)
			this.ifSegment.setParent(this);

		if (this.elseSegment != null)
			this.elseSegment.setParent(this);

	}

	@Override
	protected boolean hasBlock() {
		return false;
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.condition = LangUtils.optimize(this.condition, context);

		if (LangUtils.isOptimizable(this.condition)) {

			boolean v = (Boolean) ConvertUtils.convert(this.condition.eval(context), Boolean.class);

			if (v) {
				return this.ifSegment.optimize(context);
			} else {
				return this.elseSegment.optimize(context);
			}
		}

		return this;

	}

	@Override
	public Result doEval(MModelContext context) {

		boolean condition = (Boolean) ConvertUtils.convert(LangUtils.eval(this.condition, context), Boolean.class);

		if (condition) {

			return LangUtils.eval(this.ifSegment, context);
		} else if (this.elseSegment != null) {
			return LangUtils.eval(this.elseSegment, context);
		}

		return null;
	}

}
