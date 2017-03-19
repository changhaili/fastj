package net.fastj.lang.node;

import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.ReturnResult;

public class FunctionNode extends AbstractLangNode {

	private final String name;

	private final String[] formals;

	private final LangNode[] defaults;

	private final LangNode[] segments;

	public FunctionNode(SourceInfo source, String name, String[] formals, LangNode[] segments, LangNode[] defaults) {

		super(source);
		this.name = name;
		this.formals = formals;
		this.segments = segments;
		this.defaults = defaults;

		for (LangNode node : segments) {
			node.setParent(this);
		}

		for (LangNode node : defaults) {
			node.setParent(this);
		}

	}

	public boolean isOptimizeComplete() {

		for (int i = 0; i < this.defaults.length; i++) {

			if (!LangUtils.isOptimizable(this.defaults[i])) {
				return false;
			}
		}

		for (int i = 0; i < this.segments.length; i++) {
			if (!LangUtils.isOptimizable(this.segments[i])) {
				return false;
			}
		}

		return true;
	}

	public LangNode optimize(MModelContext datums) {

		for (int i = 0; i < this.defaults.length; i++) {
			this.defaults[i] = LangUtils.optimize(this.defaults[i], datums);

		}

		for (int i = 0; i < this.segments.length; i++) {
			this.segments[i] = LangUtils.optimize(this.segments[i], datums);

		}

		return this;
	}

	public Result invoke(MModelContext context, Object[] args) {
		return this.doInvoke(context.newFrame(), args);
	}

	protected Result doInvoke(MModelContext context, Object[] args) {

		context.putConstants("__FUNCTION__", this.name);

		for (int i = 0; i < this.formals.length; i++) {

			String formal = this.formals[i];

			Object v = null;

			if (i < args.length) {
				v = args[i];
			} else if (this.defaults != null) {

				int index = i - this.formals.length + this.defaults.length;
				if (0 <= index && index < this.defaults.length) {
					v = LangUtils.eval(this.defaults[index], context).get();
				}
			}
			context.defineCustomer(formal, v);
		}

		Result v = null;
		for (LangNode segment : this.segments) {
			v = LangUtils.eval(segment, context);

			if (v instanceof ReturnResult) {
				return new ConstResult(((ReturnResult) v).get());
			}
		}

		return v;

	}

	public String[] getFormals() {
		return this.formals;
	}

	public LangNode[] getDefaults() {
		return defaults;
	}

	public LangNode[] getSegments() {
		return segments;
	}

	@Override
	protected Result doEval(MModelContext context) {
		context.putFunction(this.name, this);
		return new ConstResult(this);
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		super.doOptimize(datums);

		if (this.isOptimizeComplete()) {
			return this.optimizes(datums);
		}

		return this;
	}

	public String getName() {
		return this.name;
	}
}
