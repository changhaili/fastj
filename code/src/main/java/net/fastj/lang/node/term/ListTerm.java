package net.fastj.lang.node.term;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class ListTerm extends AbstractLangNode {

	private LangNode[] nodes;

	public ListTerm(SourceInfo source, LangNode[] nodes) {

		super(source);

		this.nodes = nodes;

		for (LangNode node : nodes) {
			node.setParent(this);
		}

	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		for (int i = 0; i < nodes.length; i++) {
			this.nodes[i] = LangUtils.optimize(this.nodes[i], context);
		}

		return this.optimizes(context, this.nodes);
	}

	@Override
	public Result doEval(MModelContext context) {

		List<Object> list = new ArrayList<Object>();

		CollectionUtils.addAll(list, LangUtils.evalValues(context, this.nodes));

		return new ConstResult(list);

	}

}
