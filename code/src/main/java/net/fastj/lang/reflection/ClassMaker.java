package net.fastj.lang.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
import net.fastj.collection.ArrayKey;
import net.fastj.lang.DynamicInvokeHandler;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.mmodel.MModelContext;

public class ClassMaker {

	public static final ConcurrentHashMap<Class<?>, Map<String, Method>> classMethods = new ConcurrentHashMap<>();

	private final static String HANDLER_FILED_NAME = "__invokeHandler";

	private final static AtomicLong index = new AtomicLong();

	public static String getSuperMethodName(String methodName) {
		return methodName + "$Super$Proxy";
	}

	public static String getProxyClassName(String className) {
		return className + "$Proxy" + "$" + index.incrementAndGet();
	}

	public static Object invokeHandler(Object obj, String methodName, Object handler, Object[] args) {

		Map<String, Method> methods = classMethods.get(obj.getClass());

		Method method = methods.get(methodName);
		InvokeHandler h = (InvokeHandler) handler;

		InvokeArgument arguments = new InvokeArgument(obj, method, args);

		try {

			h.preInvoke(arguments);

			Object result = h.invoke(arguments);
			return h.postInvoke(result, arguments);

		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private final Class<?>[] superClasses;

	public ClassMaker(Class<?>[] superClasses) {
		this.superClasses = superClasses;
	}

	private void appendMethod(CtClass newClass, Method method) throws NotFoundException, CannotCompileException {

		Class<?>[] parameterTypes = method.getParameterTypes();

		CtClass[] parameters = new CtClass[parameterTypes.length];

		Class<?> returnType = method.getReturnType();

		{
			StringBuilder args = new StringBuilder("new Object[] {");

			for (int i = 0; i < parameterTypes.length; i++) {
				parameters[i] = Reflections.getCtClass(parameterTypes[i]);

				if (i != 0) {
					args.append(",");
				}
				args.append("$").append(i + 1);
			}

			args.append("}");

			if (parameters.length == 0) {
				args = new StringBuilder("new Object[0]");
			}

			CtMethod overrideMethod = new CtMethod(Reflections.getCtClass(returnType), method.getName(), parameters,
					newClass);

			StringBuilder methodBody = new StringBuilder("{");

			methodBody.append(MessageFormat.format("Object obj = {0}.invokeHandler(this, \"{1}\", {2}, {3} );",
					ClassMaker.class.getName(), method, HANDLER_FILED_NAME, args));

			if (Reflections.isBasePrimitive(returnType)) {

				Class<?> rType = Reflections.getPrimitivePackageClass(returnType);

				methodBody.append(MessageFormat.format("return {0}.castPrimitive(({1})obj); ",
						Reflections.class.getName(), rType.getName()));

			} else if (returnType != Void.class && returnType != void.class) {
				methodBody.append(MessageFormat.format("return ({0})obj; ", returnType.getName()));

			}

			methodBody.append("}");

			overrideMethod.setBody(methodBody.toString());

			newClass.addMethod(overrideMethod);

			overrideMethod.setModifiers(Modifier.PUBLIC);
		}

		if ((method.getModifiers() & Modifier.ABSTRACT) != Modifier.ABSTRACT) {

			CtMethod superMethod = new CtMethod(Reflections.getCtClass(returnType),
					getSuperMethodName(method.getName()), parameters, newClass);

			StringBuilder methodBody = new StringBuilder("{");

			if (returnType != Void.class && returnType != void.class) {
				methodBody.append("return  ");
			}

			methodBody.append(MessageFormat.format("super.{0}( $$ );", method.getName()));

			methodBody.append("}");

			superMethod.setBody(methodBody.toString());

			newClass.addMethod(superMethod);

			superMethod.setModifiers(Modifier.PUBLIC);
		}
		
	}

	private Class<?> makeClass(Class<?> superClass, Class<?>[] interfaceClasses, Method[] methods)
			throws NotFoundException, CannotCompileException {

		String className = (superClass == null) ? interfaceClasses[0].getSimpleName() : superClass.getSimpleName();

		className = getProxyClassName(className);

		CtClass newClass = superClass == null ? Reflections.ASSIST_POOL.makeClass(className)
				: Reflections.ASSIST_POOL.makeClass(className, Reflections.getCtClass(superClass));

		for (Class<?> interfaceClass : interfaceClasses) {
			newClass.addInterface(Reflections.getCtClass(interfaceClass));
		}

		CtClass handlerClass = Reflections.getCtClass(Object.class);

		CtField handleField = new CtField(handlerClass, HANDLER_FILED_NAME, newClass);
		handleField.setModifiers(javassist.Modifier.PUBLIC | javassist.Modifier.FINAL);
		newClass.addField(handleField);

		CtConstructor con = new CtConstructor(new CtClass[] { handlerClass }, newClass);
		String body = "{ this." + HANDLER_FILED_NAME + " = $1 ; } ";
		con.setBody(body);
		newClass.addConstructor(con);

		for (Method method : methods) {
			this.appendMethod(newClass, method);
		}
		Class<?> declaredClass = newClass.toClass();

		return declaredClass;

	}

	public Class<?> makeClass() throws NotFoundException, CannotCompileException {

		HashMap<ArrayKey, Method> methodMap = new HashMap<ArrayKey, Method>();

		Class<?> superClass = null;
		List<Class<?>> interfaceClasses = new ArrayList<Class<?>>();

		for (Class<?> s : this.superClasses) {

			if (s.isInterface()) {
				interfaceClasses.add(s);
			} else {
				if (superClass != null) {
					throw new CannotCompileException("only one super class supported!");
				}
				superClass = s;
			}

			if ((s.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
				continue;

			Method[] methods = s.getMethods();

			for (Method m : methods) {

				if ((m.getModifiers() & Modifier.FINAL) == Modifier.FINAL)
					continue;

				ArrayKey key = new ArrayKey(m).addAll((Object[]) m.getParameterTypes());

				if (methodMap.containsKey(key)) {

					if ((m.getModifiers() & Modifier.ABSTRACT) != Modifier.ABSTRACT) {
						methodMap.put(key, m);
					}
				} else {
					methodMap.put(key, m);
				}
			}
		}

		Method[] methods = methodMap.values().toArray(new Method[methodMap.size()]);

		Class<?> madeClass = this.makeClass(superClass, interfaceClasses.toArray(new Class<?>[interfaceClasses.size()]),
				methods);

		HashMap<String, Method> name2MethodMap = new HashMap<>();

		for (Method method : methods) {
			name2MethodMap.put(method.toString(), method);
		}

		classMethods.put(madeClass, name2MethodMap);

		return madeClass;
	}

	public Object newObject(InvokeHandler handler) {

		try {
			Class<?> cls = this.makeClass();
			return cls.getConstructors()[0].newInstance(handler);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static Object createProxy(MModelContext context, DynamicObject handler, Class<?>... superClasses) {

		return new ClassMaker(superClasses).newObject(new DynamicInvokeHandler(handler, context));

	}

	public static Object invokeProxy(MModelContext context, Object proxy, Object[] args) {

		try {

			Class<?> cls = proxy.getClass();
			Field field = cls.getField(HANDLER_FILED_NAME);

			// Reflections.getField(proxy.getClass(), HANDLER_FILED_NAME);
			Object handler = field.get(proxy);

			DynamicObject innerHandler = ((DynamicInvokeHandler) handler).handler;

			return innerHandler.invokeFunction("()", context, args);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
