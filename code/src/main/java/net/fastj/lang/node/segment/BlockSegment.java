package net.fastj.lang.node.segment;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.BreakResult;
import net.fastj.lang.result.ContinueResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class BlockSegment extends AbstractSegment {

	private final LangNode[] nodes ;

	public BlockSegment(SourceInfo source, LangNode[] nodes) {

		super(source);
		this.nodes = nodes;

		for (LangNode node : nodes) {
			node.setParent(this);
		}
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		for (int i = 0; i < nodes.length; i++) {
			this.nodes[i] = LangUtils.optimize(this.nodes[i], datums);
		}

		return this.optimizes(datums, this.nodes);
	}

	@Override
	public Result doEval(MModelContext datums) {

		Result v = null;

		if (this.nodes != null) {
			for (LangNode node : this.nodes) {
				v = LangUtils.eval(node, datums);

				if (ReturnResult.isReturn(v) || v instanceof BreakResult || v instanceof ContinueResult) {
					return v;
				}
			}
		}

		return v;
	}

}
