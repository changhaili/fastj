package net.fastj.lang.node.segment;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.BreakResult;
import net.fastj.lang.result.Result;

public class SwitchSegment extends AbstractSegment {

	LangNode inputNode;

	LangNode[] tables;

	LangNode defaultSegment;

	LangNode[] segments;

	public SwitchSegment(SourceInfo source, LangNode inputNode, LangNode[] tables, LangNode defaultSegment,
			LangNode[] segments) {

		super(source);

		this.inputNode = inputNode;
		this.tables = tables;
		this.defaultSegment = defaultSegment;
		this.segments = segments;

		if (this.inputNode != null)
			this.inputNode.setParent(this);

		if (this.defaultSegment != null)
			this.defaultSegment.setParent(this);

		for (LangNode node : tables) {
			node.setParent(this);
		}

		for (LangNode node : segments) {
			node.setParent(this);
		}
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		boolean optimizable = true;

		this.inputNode = LangUtils.optimize(this.inputNode, context);
		this.defaultSegment = LangUtils.optimize(this.defaultSegment, context);

		if (!LangUtils.isOptimizable(this.inputNode)) {
			optimizable = false;
		}

		if (optimizable && !LangUtils.isOptimizable(this.defaultSegment)) {
			optimizable = false;
		}

		for (int i = 0; i < tables.length; i++) {
			this.tables[i] = LangUtils.optimize(this.tables[i], context);

			if (optimizable && !LangUtils.isOptimizable(this.tables[i])) {
				optimizable = false;
			}

		}

		for (int i = 0; i < segments.length; i++) {
			this.segments[i] = LangUtils.optimize(this.segments[i], context);

			if (optimizable && !LangUtils.isOptimizable(this.segments[i])) {
				optimizable = false;
			}
		}

		if (optimizable) {
			return this.optimizes(context);
		}

		return this;

	}

	private static boolean equals(Object v0, Object v1) {
		if (v0 == v1) {
			return true;
		}

		if (v0 == null || v1 == null) {
			return false;
		}

		return v0.equals(v1);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result inputObject = LangUtils.eval(this.inputNode, context);

		boolean found = false;

		for (int i = 0; i < this.tables.length; i++) {

			if (!found) {

				Result obj = LangUtils.eval(this.tables[i], context);
				if (equals(inputObject, obj)) {
					found = true;
				}
			}

			if (found) {

				LangNode segment = this.segments[i];

				Result v = LangUtils.eval(segment, context);

				if (v instanceof Result) {
					return v;
				}

				if (v instanceof BreakResult) {
					return null;
				}
			}
		}

		if (this.defaultSegment != null) {

			Result v = LangUtils.eval(defaultSegment, context);

			if (v instanceof BreakResult) {
				return null;
			}
		}

		return null;
	}

}
