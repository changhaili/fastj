package net.fastj.lang.node.term;

import org.apache.commons.beanutils.ConvertUtils;

import net.fastj.CompileException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.JavaKlassResult;

public class AsTerm extends AbstractLangNode {

	private LangNode value;

	private LangNode type;

	public AsTerm(SourceInfo source, LangNode value, LangNode type) {
		super(source);
		this.value = value;
		this.type = type;

		this.value.setParent(this);
		this.type.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.value = LangUtils.optimize(this.value, context);
		this.type = LangUtils.optimize(this.type, context);

		return this.optimizes(context, this.value, this.type);

	}

	@Override
	public Result doEval(MModelContext context) {

		Result obj = LangUtils.eval(this.value, context);
		Result cls = LangUtils.eval(this.type, context);

		if (cls instanceof JavaKlassResult) {
			cls = new ConstResult(((JavaKlassResult) cls).getType());
		}

		if (!(cls.get() instanceof Class)) {
			throw new CompileException(this.source, "second expr must be a class!");
		}

		return new ConstResult(ConvertUtils.convert(obj.get(), (Class<?>) cls.get()));

	}

}
