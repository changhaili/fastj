package net.fastj.lang.node.term;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;

public class ParenthesisTerm extends AbstractLangNode {

	private final LangNode[] nodes;

	public ParenthesisTerm(SourceInfo source, LangNode[] nodes) {

		super(source);
		this.nodes = nodes;

		for (LangNode node : nodes) {
			node.setParent(this);
		}
	}

	public Object[] evalArray(MModelContext context) {
		return LangUtils.evalValues(context, this.nodes);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.optimizeNodes(context);
		return this.optimizes(context, this.nodes);
	}

	public boolean optimizeNodes(MModelContext context) {

		boolean optimizable = true;
		for (int i = 0; i < nodes.length; i++) {

			this.nodes[i] = LangUtils.optimize(this.nodes[i], context);

			if (optimizable && !LangUtils.isOptimizable(this.nodes[i])) {
				optimizable = false;
			}
		}

		return optimizable;

	}

	@Override
	public Result doEval(MModelContext context) {

		if (this.nodes == null || nodes.length == 0)
			return null;

		return LangUtils.eval(this.nodes[this.nodes.length - 1], context);

	}
}
