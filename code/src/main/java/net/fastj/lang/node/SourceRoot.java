package net.fastj.lang.node;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class SourceRoot extends AbstractLangNode {

	private final LangNode[] nodes;

	public SourceRoot(SourceInfo source, LangNode[] nodes) {

		super(source);
		this.nodes = nodes;

		for (LangNode node : nodes) {
			node.setParent(this);
		}
	}

	@Override
	public Result eval(MModelContext context) {

		this.fillConstants(context);
		return this.doEval(context);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = null;

		if (this.nodes != null) {
			for (LangNode node : this.nodes) {
				v = LangUtils.eval(node, context);

				if (ReturnResult.isReturn(v)) {
					return v;
				}
			}
		}
		return v;
	}

}
