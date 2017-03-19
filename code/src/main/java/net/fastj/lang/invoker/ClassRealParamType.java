package net.fastj.lang.invoker;

import net.fastj.lang.reflection.Reflections;

public class ClassRealParamType extends RealParamType {

	private Class<?> realClass;

	public ClassRealParamType(Class<?> realClass) {
		this.realClass = realClass;
	}

	@Override
	public int getDistanceTo(Class<?> formalClass) {
		return Reflections.getArgDistance(this.realClass, formalClass);
	}

	@Override
	public boolean isArray() {
		return this.realClass.isArray();
	}

	@Override
	public Class<?> getComponentType() {
		return this.realClass.getComponentType();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;

		if (!(obj instanceof ClassRealParamType)) {
			return false;
		}

		return this.realClass == ((ClassRealParamType) obj).realClass;
	}

	@Override
	public int hashCode() {
		return this.realClass.hashCode();
	}

}
