package net.fastj.lang.result.klass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;

import net.fastj.lang.LangException;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.result.AbstractResult;

public class JavaMemberResult extends AbstractResult {

	private final Object parent;

	private final Class<?> declare;

	private final String name;

	public JavaMemberResult(Object parent, Class<?> declare, String name) {

		this.parent = parent;
		this.declare = declare;
		this.name = name;

	}

	private Field field = null;

	public JavaFieldResult getField() {

		if (this.field == null) {
			this.field = Reflections.getField(declare, this.name);
		}

		if (this.field != null)
			return new JavaFieldResult(this.field, parent);

		return null;
	}

	private Class<?> innerClass;

	public JavaKlassResult getInnerType() {

		if (this.innerClass == null) {
			this.innerClass = Reflections.getInnerClass(declare, this.name);
		}
		if (this.innerClass != null)
			return new JavaKlassResult(this.innerClass);

		return null;
	}

	private Method method;

	public JavaMethodResult getMethod() {

		if (this.method == null) {
			Method[] declaredMethods = ReflectionUtils.getAllDeclaredMethods(declare);

			for (Method method : declaredMethods) {

				if (method.getName().equals(this.name)) {
					this.method = method;
					break;
				}
			}
		}

		if (this.method != null) {
			return new JavaMethodResult(parent, declare, this.name);
		}

		return null;
	}

	@Override
	public Object get() {

		JavaFieldResult field = this.getField();

		if (field != null) {
			return field.get();
		}
		throw new LangException("only support field!");
	}

	@Override
	public void set(Object value) {

		JavaFieldResult field = this.getField();

		if (field != null) {
			field.set(value);
			return;
		}
		throw new LangException("only support field!");
	}

}
