package net.fastj.lang.node.term;

import net.fastj.CompileException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.JavaKlassResult;

public class DefaultTerm extends AbstractLangNode {

	private LangNode type;

	public DefaultTerm(SourceInfo source, LangNode type) {

		super(source);
		this.type = type;
		
		this.type.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.type = LangUtils.optimize(this.type, context);
		return this.optimizes(context, this.type);
	}

	@Override
	public Result doEval(MModelContext context) {

		Result cls = LangUtils.eval(this.type, context);

		if (cls instanceof JavaKlassResult) {
			cls = new ConstResult(((JavaKlassResult) cls).getType());
		}

		if (!(cls.get() instanceof Class)) {
			throw new CompileException(this.source, "must be a class!");
		}

		return new ConstResult(Reflections.getDefault((Class<?>) cls.get()));

	}

}
