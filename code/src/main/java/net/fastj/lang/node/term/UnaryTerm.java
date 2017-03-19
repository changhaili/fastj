package net.fastj.lang.node.term;

import org.antlr.v4.runtime.Token;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.OperatorInvoker;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class UnaryTerm extends AbstractLangNode {

	private LangNode node;

	private final Token operator;

	public UnaryTerm(SourceInfo source, LangNode node, Token operator) {

		super(source);
		this.node = node;
		this.operator = operator;

		this.node.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.node = LangUtils.optimize(this.node, context);
		return this.optimizes(context, this.node);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result arg = LangUtils.eval(this.node, context);

		Object v = LangUtils.toValue(arg);

		if (v instanceof DynamicObject) {
			return new ConstResult(
					((DynamicObject) v).invokeFunction(this.operator.getText(), context, new Object[0]));
		}

		return new OperatorInvoker(context, this.operator.getText(), new Object[] { v }).invoke();

	}

}
