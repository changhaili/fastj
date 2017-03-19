package net.fastj.lang.node.term;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class ConstTerm extends AbstractLangNode {

	private final Object value;

	public ConstTerm(SourceInfo source, Object value) {

		super(source);
		this.value = value;
	}

	@Override
	public Result doEval(MModelContext context) {
		return new ConstResult(this.value);
	}

}
