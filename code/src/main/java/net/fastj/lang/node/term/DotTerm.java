package net.fastj.lang.node.term;

import org.apache.commons.lang.ArrayUtils;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.IDResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.DynamicFieldResult;
import net.fastj.lang.result.klass.DynamicMemberResult;
import net.fastj.lang.result.klass.JavaFieldResult;
import net.fastj.lang.result.klass.JavaKlassResult;
import net.fastj.lang.result.klass.JavaMemberResult;

public class DotTerm extends AbstractLangNode {

	private LangNode home;

	private final String current;

	public DotTerm(SourceInfo source, LangNode home, String current) {

		super(source);

		this.home = home;
		this.current = current;

		this.home.setParent(this);
	}

	@Override
	public LangNode doOptimize(MModelContext context) {

		this.home = LangUtils.optimize(this.home, context);
		return this;
	}

	public static DotTerm accept(SourceInfo source, LangNode parent, String id) {
		return new DotTerm(source, parent, id);
	}

	public Object invoke(SourceInfo source, LangNode[] args) {
		return new InvokeTerm(source, this, args, false);
	}

	private Result evalMembers(Class<?> declare, Object parent) {

		if (parent == null) {

			if ("class".equals(this.current)) {
				return new ConstResult(declare);
			}
		} else {

			if (Reflections.isArray(parent) && "length".equals(this.current)) {
				return new ConstResult(ArrayUtils.getLength(parent));
			}
		}

		if (declare == DynamicObject.class) {
			return new DynamicMemberResult((DynamicObject) parent, this.current);
		} else {
			return new JavaMemberResult(parent, declare, this.current);
		}
	}

	@Override
	public Result doEval(MModelContext context) {

		Result p = LangUtils.eval(this.home, context);

		if (p instanceof DynamicMemberResult) {

			DynamicMemberResult members = (DynamicMemberResult) p;

			DynamicFieldResult field = members.getField();
			if (field != null) {

				Object v = field.get();
				return this.evalMembers(v.getClass(), v);
			}

		} else if (p instanceof JavaMemberResult) {

			JavaMemberResult members = (JavaMemberResult) p;

			JavaFieldResult field = members.getField();
			if (field != null) {

				Object v = field.get();
				return this.evalMembers(v.getClass(), v);
			}

			JavaKlassResult type = members.getInnerType();
			if (type != null) {

				Class<?> v = type.getType();
				return this.evalMembers(v, null);
			}

		} else if (p instanceof IDResult) {
			return LangUtils.eval(new IDTerm(this.source, ((IDResult) p).getName() + "." + this.current), context
					);

		} else if (p instanceof JavaKlassResult) {
			return this.evalMembers(((JavaKlassResult) p).getType(), null);

		} else {
			Object v = p.get();
			return this.evalMembers(v.getClass(), v);
		}

		throw new LangException("value error!");

	}

}
