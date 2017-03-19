package net.fastj.lang.node.term;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fastj.lang.LangUtils;
import net.fastj.lang.invoker.InvokeUtils;
import net.fastj.lang.invoker.OperatorInvoker;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.IDResult;
import net.fastj.lang.result.Result;

public class AssignTerm extends AbstractLangNode {

	public final static Logger LOGGER = LoggerFactory.getLogger(InvokeUtils.class);

	private LangNode leftNode;

	private LangNode rightNode;

	private String operator;

	public AssignTerm(SourceInfo source, LangNode leftNode, LangNode rightNode, String operator) {

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
		this.rightNode = LangUtils.optimize(this.rightNode, context);

		return this.optimizes(context, this.leftNode, this.rightNode);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result leftVariable = LangUtils.eval(this.leftNode, context);

		Result rightVariable = LangUtils.eval(this.rightNode, context);

		if (this.operator.equals("=")) {

			if (leftVariable instanceof IDResult) {

				String name = ((IDResult) leftVariable).getName();

				return LangUtils.assignCustumer(this, context, name, rightVariable.get());

			} else {

				leftVariable.set(rightVariable.get());
				return leftVariable;
			}

		}

		final String preOp = this.operator.substring(0, this.operator.length() - 1);

		try {

			Result v = new OperatorInvoker(context, preOp, new Object[] { leftVariable.get(), rightVariable.get() })
					.invoke();

			leftVariable.set(v.get());

			return leftVariable;

		} catch (Exception ex) {
			LOGGER.debug(ex.getMessage(), ex);
		}

		// Member[] methods = BinaryOperators.getSatisfyMethods(preOp,
		// leftVariable.get(), rightVariable.get());
		//
		// if (methods != null && methods.length > 0) {
		//
		// Variable v = Reflections.invokeTopMethod(methods, null,
		// new Object[] { leftVariable.get(), rightVariable.get() });
		// leftVariable.set(v.get());
		//
		// return leftVariable;
		// }

		try {

			Result v = new OperatorInvoker(context, this.operator,
					new Object[] { leftVariable.get(), rightVariable.get() }).invoke();

			leftVariable.set(v.get());

			return leftVariable;

		} catch (Exception ex) {
			LOGGER.debug(ex.getMessage(), ex);
		}

		// // TODO
		// methods =
		// InvokeUtils.getSatisfyMethods(leftVariable.get().getClass(), op,
		// RealParamType.getRealParamTypes(context, new Object[] {
		// rightVariable.get() }));
		//
		// if (methods != null && methods.length > 0) {
		// Variable v = Reflections.invokeTopMethod(methods, leftVariable.get(),
		// new Object[] { rightVariable.get() });
		//
		// leftVariable.set(v.get());
		// return leftVariable;
		// }

		// TODO
		// methods =
		// InvokeUtils.getSatisfyMethods(leftVariable.get().getClass(), preOp,
		// RealParamType.getRealParamTypes(context, new Object[] {
		// rightVariable.get() }));
		//
		// if (methods != null && methods.length > 0) {
		// Variable v = Reflections.invokeTopMethod(methods, leftVariable.get(),
		// new Object[] { rightVariable.get() });
		//
		// leftVariable.set(v.get());
		// return leftVariable;
		// }
		//
		// return null;

		return ConstResult.NULL;
	}

}
