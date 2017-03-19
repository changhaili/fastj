package net.fastj.lang.node.term;

import org.antlr.v4.runtime.Token;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fastj.antlrgenerator.LangParser;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.OperatorInvoker;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class BinaryTerm extends AbstractLangNode {

	private final static Logger logger = LoggerFactory.getLogger(BinaryTerm.class);

	private LangNode leftNode;

	private LangNode rightNode;

	private final Token operator;

	public BinaryTerm(SourceInfo source, LangNode leftNode, LangNode rightNode, Token operator) {

		super(source);
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.operator = operator;

		this.leftNode.setParent(this);
		this.rightNode.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.leftNode = LangUtils.optimize(this.leftNode, context);

		if (!(this.rightNode instanceof ParenthesisTerm)) {
			this.rightNode = LangUtils.optimize(this.rightNode, context);
		}

		return this.optimizes(context, this.leftNode, this.rightNode);
	}

	@Override
	public Result doEval(MModelContext context) {

		final String op = this.operator.getText();
		final int opType = this.operator.getType();

		Result leftVariable = LangUtils.eval(this.leftNode, context);

		if (opType == LangParser.OP_NULLOR) {

			try {

				Object left = LangUtils.toValue(leftVariable);
				if (left != null) {
					return leftVariable;
				}
			} catch (Exception ex) {
				logger.debug(ex.getMessage(), ex);
			}
			return LangUtils.eval(this.rightNode, context);
		}

		Object left = LangUtils.toValue(leftVariable);

		if (left instanceof DynamicObject) {
			return new ConstResult(((DynamicObject) left).invokeFunction(op, context,
					new Object[] { LangUtils.eval(this.rightNode, context).get() }));
		}

		if (left != null && Reflections.isPrimitive(left.getClass())) {

			if (opType == LangParser.OP_BOOLEAN_AND) {

				if (!(Boolean) ConvertUtils.convert(leftVariable.get(), Boolean.class)) {
					return ConstResult.FALSE;
				}

				return new ConstResult(
						ConvertUtils.convert(LangUtils.eval(this.rightNode, context).get(), Boolean.class));

			}

			if (opType == LangParser.OP_BOOLEAN_OR) {

				if ((Boolean) ConvertUtils.convert(leftVariable.get(), Boolean.class)) {
					return ConstResult.TRUE;
				}

				return new ConstResult(
						ConvertUtils.convert(LangUtils.eval(this.rightNode, context).get(), Boolean.class));

			}
		}

		Object right = null;
		if ("%".equals(op) && (this.rightNode instanceof ParenthesisTerm)) {
			right = ((ParenthesisTerm) this.rightNode).evalArray(context);
		} else {
			right = LangUtils.toValue(LangUtils.eval(this.rightNode, context));
		}

		return new OperatorInvoker(context, op, new Object[] { left, right }).invoke();

	}

}
