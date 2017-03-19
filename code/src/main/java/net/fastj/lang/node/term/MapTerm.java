package net.fastj.lang.node.term;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class MapTerm extends AbstractLangNode {

	private final LangNode[] nodes;

	public MapTerm(SourceInfo source, LangNode[] nodes) {

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

		Map<Object, Object> map = new LinkedHashMap<Object, Object>();

		for (int i = 0; i < nodes.length; i += 2) {

			Object key = LangUtils.eval(this.nodes[i], context).get();
			Object value = LangUtils.eval(this.nodes[i + 1], context).get();

			map.put(key, value);
		}

		return new ConstResult(map);

	}

}
