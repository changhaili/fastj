package net.fastj.lang.invoker;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.commons.lang.StringUtils;

import net.fastj.collection.ArrayKey;
import net.fastj.lang.LambdaNode;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.reflection.Reflections;

public class LambdaRealParamType extends RealParamType {

	private LambdaNode lambda;

	private Class<?> formalClass;

	public LambdaRealParamType(LambdaNode lambda) {
		this.lambda = lambda;
	}

	@Override
	public int getDistanceTo(Class<?> formalClass) {

		if ((formalClass.getModifiers() & Modifier.FINAL) == Modifier.FINAL) {
			return Integer.MAX_VALUE;
		}

		int distance = Integer.MAX_VALUE;

		if (this.lambda.getDeclaredClass() != null) {
			distance = Reflections.getArgDistance(this.lambda.getDeclaredClass(), formalClass);

		} else {

			Method[] methods = Reflections.getMethodsWithoutObject(formalClass);

			int abstractCount = 0;
			for (Method method : methods) {

				if ((method.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT) {
					abstractCount++;
				}

				if (abstractCount > 1)
					return Integer.MAX_VALUE;
			}

			if (StringUtils.isNotBlank(this.lambda.getFunctionName())) {

				for (Method method : methods) {

					if ((method.getModifiers() & Modifier.FINAL) == Modifier.FINAL) {
						continue;
					}

					if (method.getName().equals(this.lambda.getFunctionName())
							&& method.getParameterCount() == this.lambda.getFunction().getFormals().length) {
						distance = 10000;
						break;
					}
				}

			} else if (methods.length != 1) {
				return Integer.MAX_VALUE;
			} else if (methods[0].getParameterCount() != this.lambda.getFunction().getFormals().length) {
				return Integer.MAX_VALUE;
			} else {
				distance = 10000;
			}
		}

		if (distance != Integer.MAX_VALUE) {
			this.formalClass = formalClass;
		}

		return distance;
	}

	public Object createObject(MModelContext context) {
		return InvokeUtils.createJavaLambdaObject(this.lambda, this.formalClass, context);

	}

	@Override
	public boolean isArray() {
		return false;
	}

	@Override
	public Class<?> getComponentType() {
		return null;
	}

	private ArrayKey asKey() {
		return new ArrayKey(this.lambda.getFunction().getFormals().length, this.lambda.getFunctionName(),
				this.lambda.getDeclaredClass(), this.formalClass);
	}

	@Override
	public int hashCode() {
		return this.asKey().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof LambdaRealParamType))
			return false;

		LambdaRealParamType other = (LambdaRealParamType) obj;

		ArrayKey thisKey = this.asKey();
		ArrayKey otherKey = other.asKey();

		return thisKey.equals(otherKey);
	}

}
