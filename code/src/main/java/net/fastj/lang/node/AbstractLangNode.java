package net.fastj.lang.node;

import org.apache.commons.lang.StringUtils;

import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.term.ConstTerm;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public abstract class AbstractLangNode implements LangNode {

	protected final SourceInfo source;

	protected LangNode parent;

	@Override
	public SourceInfo getSource() {
		return this.source;
	}

	public int getStartLine() {
		return this.source == null ? -1 : this.source.getStartLine();
	}

	public String getSourceCode() {
		return this.source == null ? null : this.source.getCode();
	}

	@Override
	public LangNode getParent() {
		return this.parent;
	}

	public void setParent(LangNode parent) {
		this.parent = parent;
	}

	protected AbstractLangNode(SourceInfo source) {
		this.source = source;
	}

	protected void fillConstants(MModelContext datums) {

		SourceInfo source = this.getSource();

		if (source != null) {
			datums.putConstants("__LINE__", source.getStartLine());
		}
	}

	@Override
	public LangNode optimize(MModelContext datums) {

		this.fillConstants(datums);
		return this.doOptimize(datums);

	}

	protected boolean hasBlock() {
		return false;
	}

	@Override
	public Result eval(MModelContext context) {

		try {

			if (this.hasBlock()) {
				context.enterBlock();
			}

			this.fillConstants(context);

			if (this.preEval(context)) {

				Result result = this.doEval(context);
				return this.postEval(result, context);

			} else {
				return ConstResult.NULL;
			}

		} catch (Exception ex) {

			int line = this.getSource().getStartLine();
			String code = this.getSourceCode();
			if (StringUtils.isNotBlank(code)) {
				throw new LangException("Error Line: " + line + "  Code : " + code, ex);
			} else {
				throw new LangException("Error Line: " + line, ex);
			}

		} finally {
			if (this.hasBlock()) {
				context.leaveBlock();
			}
		}
	}

	protected boolean preEval(MModelContext context) {
		return true;
	}

	protected Result postEval(Result result, MModelContext context) {
		return result;
	}

	protected abstract Result doEval(MModelContext context);

	protected LangNode doOptimize(MModelContext datums) {
		return this;
	}

	protected LangNode optimizes(MModelContext context, LangNode... nodes) {

		boolean optimizable = true;

		for (LangNode node : nodes) {

			if (optimizable && !LangUtils.isOptimizable(node)) {
				optimizable = false;
			}
		}

		if (optimizable) {

			Result v = this.eval(context);
			return new ConstTerm(null, v.get());
		}
		return this;
	}

	@Override
	public String toString() {
		return String.valueOf(this.getSourceCode());
	}
}
