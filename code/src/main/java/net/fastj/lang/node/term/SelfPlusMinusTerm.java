package net.fastj.lang.node.term;

import org.antlr.v4.runtime.Token;

import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.OperatorInvoker;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class SelfPlusMinusTerm extends AbstractLangNode {

	private LangNode node;

	private final Token token;

	private final boolean beforeVariant;

	public SelfPlusMinusTerm(SourceInfo source, LangNode node, Token token, boolean beforeVariant) {

		super(source);
		this.node = node;
		this.token = token;
		this.beforeVariant = beforeVariant;
	}

	@Override
	public Result doEval(MModelContext context) {

		Result v = LangUtils.eval(this.node, context);

		Object oldResult = LangUtils.toValue(v);

		Result newResult = new OperatorInvoker(context, this.token.getText(), new Object[] { oldResult })
				.invoke();

		Object result = LangUtils.toValue(newResult);

		v.set(result);

		return this.beforeVariant ? new ConstResult(result) : new ConstResult(oldResult);

	}

}
