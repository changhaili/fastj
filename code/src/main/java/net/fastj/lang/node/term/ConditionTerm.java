package net.fastj.lang.node.term;

import org.apache.commons.beanutils.ConvertUtils;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class ConditionTerm extends AbstractLangNode {

	private LangNode condition;

	private LangNode value0;

	private LangNode value1;

	public ConditionTerm(SourceInfo source, LangNode condition, LangNode value0, LangNode value1) {

		super(source);

		this.condition = condition;
		this.value0 = value0;
		this.value1 = value1;

		this.condition.setParent(this);
		this.value0.setParent(this);
		this.value0.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.condition = LangUtils.optimize(this.condition, context);

		if (LangUtils.isOptimizable(this.condition)) {

			boolean v = (Boolean) ConvertUtils.convert(this.condition.eval(context), Boolean.class);

			if (v) {
				return this.value0.optimize(context);
			} else {
				return this.value1.optimize(context);
			}
		}

		return this;
	}

	@Override
	public Result doEval(MModelContext context) {

		Object v = (Boolean) ConvertUtils.convert(LangUtils.eval(this.condition, context).get(),
				Boolean.class) ? LangUtils.eval(this.value0, context).get()
						: LangUtils.eval(this.value1, context).get();

		return new ConstResult(v);

	}

}
