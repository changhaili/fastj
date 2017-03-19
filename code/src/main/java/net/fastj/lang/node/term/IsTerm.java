package net.fastj.lang.node.term;

import net.fastj.CompileException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.JavaKlassResult;

public class IsTerm extends AbstractLangNode {

	private LangNode value;

	private LangNode type;

	public IsTerm(SourceInfo source, LangNode value, LangNode type) {

		super(source);

		this.value = value;
		this.type = type;

		this.value.setParent(this);
		this.type.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext datums) {

		this.value = LangUtils.optimize(this.value, datums);
		this.type = LangUtils.optimize(this.type, datums);

		return this.optimizes(datums, this.value, this.type);
	}

	@Override
	public Result doEval(MModelContext datums) {

		Result cls = LangUtils.eval(this.type, datums);

		if (cls instanceof JavaKlassResult) {
			cls = new ConstResult(((JavaKlassResult) cls).getType());
		}

		if (!(cls.get() instanceof Class)) {
			throw new CompileException(this.source, "second expression must be a class!");
		}

		Result obj = LangUtils.eval(this.value, datums);

		return new ConstResult(((Class<?>) cls.get()).isInstance(obj.get()));

	}

}
