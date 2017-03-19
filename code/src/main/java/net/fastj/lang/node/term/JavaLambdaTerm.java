package net.fastj.lang.node.term;

import net.fastj.lang.LambdaNode;
import net.fastj.lang.LangException;
import net.fastj.lang.invoker.InvokeUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.JavaKlassResult;
import net.fastj.lang.result.klass.JavaMemberResult;
import net.fastj.lang.result.klass.JavaMethodResult;

public class JavaLambdaTerm extends AbstractLangNode implements LambdaNode {

	private LangNode path;

	private LambdaTerm lambdaExpression;

	private Class<?> declareClass;

	private String functionName;

	private volatile boolean initialized = false;

	public JavaLambdaTerm(SourceInfo source, LangNode path, LambdaTerm lambdaExpression) {
		super(source);

		this.path = path;
		this.lambdaExpression = lambdaExpression;

	}

	public void initialize(MModelContext context) {

		if (initialized)
			return;

		initialized = true;

		try {

			if (this.path != null) {

				Result result = this.path.eval(context);

				if (result instanceof JavaMemberResult) {

					Result r = ((JavaMemberResult) result).getMethod();
					if (r != null) {
						result = r;

					} else {
						r = ((JavaMemberResult) result).getInnerType();
						if (r != null) {
							result = r;
						}
					}
				}

				if (result instanceof JavaMethodResult) {
					this.declareClass = ((JavaMethodResult) result).getDeclare();
					functionName = ((JavaMethodResult) result).getMethod();
				} else if (result instanceof JavaKlassResult) {
					this.declareClass = ((JavaKlassResult) result).getType();
					this.functionName = null;
				}
			}

		} catch (Exception ex) {
			throw new LangException(ex);
		}
	}

	@Override
	protected Result doEval(MModelContext context) {

		this.initialize(context);

		Object obj = InvokeUtils.createJavaLambdaObject(this, null, context);
		return new ConstResult(obj);
	}

	@Override
	public Class<?> getDeclaredClass() {
		return this.declareClass;
	}

	@Override
	public String getFunctionName() {
		return this.functionName;
	}

	@Override
	public FunctionNode getFunction() {
		return this.lambdaExpression.getFunction();
	}

}
