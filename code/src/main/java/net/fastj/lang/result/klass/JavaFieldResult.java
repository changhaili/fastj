package net.fastj.lang.result.klass;

import java.lang.reflect.Field;

import net.fastj.lang.LangException;
import net.fastj.lang.result.AbstractResult;

public class JavaFieldResult extends AbstractResult {

	private final Field field;

	private final Object parent;

	public JavaFieldResult(Field field, Object parent) {
		this.field = field;
		this.parent = parent;
	}

	@Override
	public Object get() {

		try {
			return field.get(this.parent);
		} catch (Exception e) {
			throw new LangException(e);
		}
	}

	@Override
	public void set(Object value) {

		try {
			field.set(this.parent, value);
		} catch (Exception e) {
			throw new LangException(e);
		}
	}
}
