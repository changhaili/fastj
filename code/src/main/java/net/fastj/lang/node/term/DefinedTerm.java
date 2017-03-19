package net.fastj.lang.node.term;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class DefinedTerm extends AbstractLangNode {

	private final String path;

	public DefinedTerm(SourceInfo source, String path) {

		super(source);

		this.path = path;
	}

	@Override
	public Result doEval(MModelContext context) {
		return new ConstResult(context.contains(this.path));
	}

}
