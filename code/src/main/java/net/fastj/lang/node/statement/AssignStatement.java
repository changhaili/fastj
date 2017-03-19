package net.fastj.lang.node.statement;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class AssignStatement extends AbstractLangNode {

	private final String name;

	private LangNode expr;

	public AssignStatement(SourceInfo source, String name, LangNode expression) {

		super(source);

		this.name = name;
		this.expr = expression;

		this.expr.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.expr = LangUtils.optimize(this.expr, context);
		return this.optimizes(context, this.expr);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = this.expr != null ? LangUtils.eval(this.expr, context) : ConstResult.NULL;

		return LangUtils.assignCustumer(this, context, name, v.get());

	}
}
