package net.fastj.lang.node.term;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.CustomerResult;
import net.fastj.lang.result.IDResult;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.klass.JavaKlassResult;

public class IDTerm extends AbstractLangNode {

	private final String name;

	public IDTerm(SourceInfo source, String name) {

		super(source);
		this.name = name;
	}

	@Override
	public Result doEval(MModelContext context) {

		if (context.isCustomer(this.name)) {
			return new CustomerResult(context, this.name);
		}

		if (context.contains(this.name)) {

			Object v = context.getValue(name);
			if (v instanceof Result) {
				return (Result) v;
			}

			return new ConstResult(context.getValue(this.name));
		}

		Class<?> cls = context.forClass(this.name);
		if (cls != null) {
			return new JavaKlassResult(cls);
		}

		return new IDResult(context, this.name);

	}

}
