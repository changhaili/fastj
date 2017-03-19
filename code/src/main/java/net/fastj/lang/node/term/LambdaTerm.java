package net.fastj.lang.node.term;

import java.util.concurrent.atomic.AtomicLong;

import net.fastj.lang.LambdaNode;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class LambdaTerm extends AbstractLangNode implements LambdaNode {

	private final static AtomicLong LAMBDA_INDEX = new AtomicLong();

	private final FunctionNode function;

	private static String getLambdaName() {

		long index = LAMBDA_INDEX.getAndIncrement();

		return "$$lambda$$" + index;
	}

	public LambdaTerm(SourceInfo source, String[] formals, LangNode segment) {

		super(source);
		this.function = new FunctionNode(source, getLambdaName(), formals, new LangNode[] { segment }, new LangNode[0]);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.function.optimize(context);
		return this;
	}

	@Override
	protected Result doEval(MModelContext context) {
		return new ConstResult(this.function);
	}

	@Override
	public Class<?> getDeclaredClass() {
		return null;
	}

	@Override
	public String getFunctionName() {

		return null;
	}

	@Override
	public FunctionNode getFunction() {
		return this.function;
	}

}
