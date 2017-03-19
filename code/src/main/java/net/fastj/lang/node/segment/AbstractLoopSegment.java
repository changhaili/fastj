package net.fastj.lang.node.segment;

import java.util.ArrayList;
import java.util.List;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public abstract class AbstractLoopSegment extends AbstractSegment {

	public static final String YIELD_LOOP_NAME = "$$YIELD_LOOP_NAME$$";

	public void addYield(MModelContext context, Object obj) {

		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) context.getValue(YIELD_LOOP_NAME);

		list.add(obj);

	}

	protected AbstractLoopSegment(SourceInfo source) {
		super(source);

	}

	@Override
	protected boolean preEval(MModelContext context) {

		context.putCustomer(YIELD_LOOP_NAME, new ArrayList<Object>());
		return super.preEval(context);
	}

	@Override
	protected Result postEval(Result result, MModelContext context) {

		if (ReturnResult.isReturn(result)) {
			return result;
		}

		@SuppressWarnings("unchecked")
		List<Object> list = (List<Object>) context.getValue(YIELD_LOOP_NAME);
		if (!list.isEmpty()) {
			return new ReturnResult(list);
		}

		return result;
	}

}
