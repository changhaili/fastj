package net.fastj.lang.node.term;

import net.fastj.collection.Collections;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class InTerm extends AbstractLangNode {

	private LangNode value;

	private LangNode collection;

	public InTerm(SourceInfo source, LangNode value, LangNode col) {

		super(source);

		this.value = value;
		this.collection = col;

		this.value.setParent(this);
		this.collection.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.value = LangUtils.optimize(this.value, context);

		if (this.collection instanceof ParenthesisTerm) {

			if (((ParenthesisTerm) this.collection).optimizeNodes(context)) {
				return this.optimizes(context, this.value);
			}

			return this;

		} else {
			this.collection = LangUtils.optimize(this.collection, context);
			return this.optimizes(context, this.value, this.collection);
		}

	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = LangUtils.eval(this.value, context);

		Object col = null;
		if (this.collection instanceof ParenthesisTerm) {
			col = ((ParenthesisTerm) this.collection).evalArray(context);
		} else {
			col = LangUtils.eval(this.collection, context);
		}

		return new ConstResult(Collections.contains(col, v.get()));
	}

}
