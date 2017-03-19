package net.fastj.lang.invoker;

import net.fastj.lang.LambdaNode;
import net.fastj.lang.mmodel.MModelContext;

public abstract class RealParamType {

	public abstract int getDistanceTo(Class<?> formalClass);

	public abstract boolean isArray();

	public abstract Class<?> getComponentType();

	public static RealParamType getRealParamType(MModelContext datums, Object obj) {

		if (obj == null) {
			return null;

		} else if (obj instanceof LambdaNode) {
			return new LambdaRealParamType((LambdaNode) obj);

		} else {
			return new ClassRealParamType(obj.getClass());
		}
	}

	public static RealParamType[] getRealParamTypes(MModelContext datums, Object[] objects) {

		if (objects == null)
			return null;

		RealParamType[] types = new RealParamType[objects.length];

		for (int i = 0; i < objects.length; i++) {
			types[i] = getRealParamType(datums, objects[i]);
		}

		return types;
	}

	public static Object[] convertObjects(MModelContext context, RealParamType[] types, Object[] objs) {

		if (objs == null || objs.length == 0)
			return objs;

		Object[] newObjects = new Object[objs.length];

		for (int i = 0; i < newObjects.length; i++) {

			Object obj = objs[i];
			RealParamType type = types[i];
			if (type instanceof LambdaRealParamType && obj instanceof LambdaNode) {
				newObjects[i] = ((LambdaRealParamType) type).createObject(context);
			} else {
				newObjects[i] = obj;
			}
		}

		return newObjects;

	}

}
