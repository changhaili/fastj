package net.fastj.lang.result.klass;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangException;
import net.fastj.lang.result.AbstractResult;

public class DynamicMemberResult extends AbstractResult {

	private final DynamicObject parent;

	private final String name;

	public DynamicMemberResult(DynamicObject parent, String name) {

		this.parent = parent;
		this.name = name;

	}

	public DynamicFieldResult getField() {

		return new DynamicFieldResult(this.parent, this.name);

	}

	public DynamicFunctionResult getFuntion() {

		if (this.parent.isFunction(this.name)) {
			return new DynamicFunctionResult(parent, name);
		}

		return null;
	}

	@Override
	public Object get() {

		if (this.parent.isField(name)) {
			return this.getField().get();
		}

		throw new LangException("only support field!");
	}

	@Override
	public void set(Object value) {

		// if (this.parent.isField(name)) {
		this.getField().set(value);
		// }

		// throw new LangException("only support field!");

	}

}
