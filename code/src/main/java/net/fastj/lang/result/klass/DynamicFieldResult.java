package net.fastj.lang.result.klass;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangException;
import net.fastj.lang.result.AbstractResult;

public class DynamicFieldResult extends AbstractResult {

	private final DynamicObject parent;

	private final String name;

	public DynamicFieldResult(DynamicObject parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	@Override
	public Object get() {

		try {
			return this.parent.getField(this.name);
		} catch (Exception e) {
			throw new LangException(e);
		}
	}

	@Override
	public void set(Object value) {

		try {
			this.parent.setField(this.name, value);
		} catch (Exception e) {
			throw new LangException(e);
		}
	}
}