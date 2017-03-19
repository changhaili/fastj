package net.fastj.lang.reflection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.backport.java.util.Arrays;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;

public class Reflections {

	private static final Logger logger = LoggerFactory.getLogger(Reflections.class);

	public static interface ExecutableCallback {

		Object invoke(Member executable, Object... args);
	}

	public static Field getField(Class<?> targetClass, String name) {

		Field field = null;
		try {
			field = targetClass.getField(name);
		} catch (Exception e) {

		}
		if (field != null)
			return field;

		if (targetClass.getSuperclass() == null || targetClass.getSuperclass() == Object.class) {
			return null;
		}

		return getField(targetClass.getSuperclass(), name);
	}

	public static void getAllFields(Class<?> targetClass, List<Field> fields) {

		for (Field field : targetClass.getDeclaredFields()) {

			fields.add(field);
		}

		if (targetClass.getSuperclass() == null || targetClass.getSuperclass() == Object.class) {
			return;
		}

		getAllFields(targetClass.getSuperclass(), fields);

	}

	public static boolean isAbstract(Method method) {
		return (method.getModifiers() & Modifier.ABSTRACT) == Modifier.ABSTRACT;
	}

	public static Class<?> getInnerClass(Class<?> parent, String name) {

		for (Class<?> sub : parent.getClasses()) {
			if (sub.getSimpleName().equals(name)) {
				return sub;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] convertArray(Object[] values, Class<?> cls, Converter converter) {

		T[] vs = (T[]) Array.newInstance(cls, values.length);

		for (int i = 0; i < values.length; i++) {

			vs[i] = (T) converter.convert(cls, values[i]);
		}

		return vs;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] convertArray(Object[] values, Class<?> cls) {

		T[] vs = (T[]) Array.newInstance(cls, values.length);

		for (int i = 0; i < values.length; i++) {

			vs[i] = (T) ConvertUtils.convert(values[i], cls);
		}

		return vs;
	}

	public static boolean isExtends(Class<?> parent, Class<?> child) {

		if (parent == child)
			return true;

		return parent == null ? false : parent.isAssignableFrom(child);
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(Object v, Class<T> cls, T defaultValue) {

		if (v == null)
			return defaultValue;

		try {

			Object newValue = ConvertUtils.convert(v, cls);

			if (newValue == null)
				return defaultValue;

			return (T) newValue;
		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
			return defaultValue;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T convert(Object v, Class<T> cls) {

		try {

			Object newValue = ConvertUtils.convert(v, cls);

			if (newValue == null)
				return null;

			return (T) newValue;
		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
			return null;
		}
	}

	public static Object[] convertArray(Object[] array, Class<?>[] classes) {

		Object[] newArray = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = ConvertUtils.convert(array[i], classes[i]);
		}

		return newArray;
	}

	public static boolean isArray(Object v) {

		if (v == null)
			return false;

		return v.getClass().isArray();
	}

	public static byte[] serial(Object obj) throws IOException {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(obj);
		oos.flush();

		byte[] bytes = bos.toByteArray();
		oos.close();
		return bytes;
	}

	public static Object deserial(byte[] bytes, int begin, int length) throws IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes, begin, length));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	public static Class<?> classForName(String className, Class<?> defaultClass, String... packages) {

		if (StringUtils.isBlank(className)) {
			return defaultClass;
		} else {

			if ("boolean".equals(className)) {
				return boolean.class;
			}
			if ("byte".equals(className)) {
				return byte.class;
			}
			if ("char".equals(className)) {
				return char.class;
			}
			if ("short".equals(className)) {
				return short.class;
			}
			if ("int".equals(className)) {
				return int.class;
			}
			if ("long".equals(className)) {
				return long.class;
			}
			if ("float".equals(className)) {
				return float.class;
			}
			if ("double".equals(className)) {
				return double.class;
			}
			if ("string".equals(className)) {
				return String.class;
			}
			if ("object".equals(className)) {
				return Object.class;
			}
			if ("void".equals(className)) {
				return Void.class;
			}

			try {
				return Class.forName(className);
			} catch (ClassNotFoundException e) {
				logger.debug(e.getMessage(), e);

				for (String p : packages) {

					try {
						return Class.forName(p + "." + className);
					} catch (ClassNotFoundException e1) {
						logger.debug(e1.getMessage(), e1);
					}
				}
			}

		}
		return defaultClass;
	}

	public static boolean isArrayExtends(Class<?>[] parentTypes, Class<?>[] types) {

		if (parentTypes == types)
			return true;

		int l0 = parentTypes == null ? 0 : parentTypes.length;
		int l1 = types == null ? 0 : types.length;

		if (l0 != l1)
			return false;

		if (l0 == 0)
			return true;

		if (parentTypes == null || types == null)
			return false;

		for (int i = 0; i < types.length; i++) {

			if (types[i] != null && !Reflections.isExtends(parentTypes[i], types[i])) {
				return false;
			}

		}

		return true;
	}

	public static <T> Constructor<?> getConstructor(Class<T> cls, Class<?>[] argTypes) {

		for (Constructor<?> con : cls.getConstructors()) {

			Class<?>[] types = con.getParameterTypes();

			if (isArrayExtends(types, argTypes))
				return con;

		}

		return null;

	}

	public static Object createObject(Class<?> cls, Object... args)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		if (args == null || args.length == 0) {
			return cls.newInstance();
		}

		Class<?>[] types = new Class<?>[args.length];

		for (int i = 0; i < types.length; i++) {
			types[i] = args[i] == null ? null : args[i].getClass();
		}

		Constructor<?> con = getConstructor(cls, types);

		return con.newInstance(args);

	}

	public static boolean isPrimitive(Class<?> type) {
		return isBasePrimitive(type) || isPackagePrimitive(type);
	}

	public static boolean isBasePrimitive(Class<?> type) {

		if (type == boolean.class) {
			return true;
		} else if (type == byte.class) {
			return true;
		} else if (type == char.class) {
			return true;
		} else if (type == short.class) {
			return true;
		} else if (type == int.class) {
			return true;
		} else if (type == long.class) {
			return true;
		} else if (type == float.class) {
			return true;
		} else if (type == double.class) {
			return true;
		}

		return false;
	}

	public static boolean isPackagePrimitive(Class<?> type) {

		if (type == Boolean.class) {
			return true;
		} else if (type == Byte.class) {
			return true;
		} else if (type == Character.class) {
			return true;
		} else if (type == Short.class) {
			return true;
		} else if (type == Integer.class) {
			return true;
		} else if (type == Long.class) {
			return true;
		} else if (type == Float.class) {
			return true;
		} else if (type == Double.class) {
			return true;
		}

		return false;
	}

	public static int getPrimitiveTypeDistance(Class<?> type0, Class<?> type1) {

		int t = -1;

		Class<?> type = type0;

		if (type == Boolean.class || type == boolean.class) {
			t = 1;
		} else if (type == Byte.class || type == byte.class) {
			t = 2;
		} else if (type == Character.class || type == char.class) {
			t = 3;
		} else if (type == Short.class || type == short.class) {
			t = 4;
		} else if (type == Integer.class || type == int.class) {
			t = 5;
		} else if (type == Long.class || type == long.class) {
			t = 6;
		} else if (type == Float.class || type == float.class) {
			t = 7;
		} else if (type == Double.class || type == double.class) {
			t = 8;
		}

		int t0 = t;

		t = -1;
		type = type1;

		if (type == Boolean.class || type == boolean.class) {
			t = 1;
		} else if (type == Byte.class || type == byte.class) {
			t = 2;
		} else if (type == Character.class || type == char.class) {
			t = 3;
		} else if (type == Short.class || type == short.class) {
			t = 4;
		} else if (type == Integer.class || type == int.class) {
			t = 5;
		} else if (type == Long.class || type == long.class) {
			t = 6;
		} else if (type == Float.class || type == float.class) {
			t = 7;
		} else if (type == Double.class || type == double.class) {
			t = 8;
		}

		int t1 = t;

		return t0 - t1;

	}

	public static Object boostPrimitive(Object v, Class<?> cmpClass) {

		int c = getPrimitiveTypeDistance(v.getClass(), cmpClass);

		return c < 0 ? ConvertUtils.convert(v, cmpClass) : v;

	}

	public static boolean canConvert(Object v, Class<?> targetClass) {

		try {
			ConvertUtils.convert(v, targetClass);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static Class<?>[] getClasses(Object... values) {

		if (values == null) {
			return new Class<?>[0];
		}

		Class<?>[] cs = new Class<?>[values.length];

		for (int i = 0; i < values.length; i++) {
			cs[i] = values[i] == null ? null : values[i].getClass();
		}

		return cs;
	}

	public static int getArgDistance(Class<?> realClass, Class<?> formalClass) {

		if (Reflections.isPrimitive(realClass) != Reflections.isPrimitive(formalClass) && formalClass != Object.class) {
			return Integer.MAX_VALUE;
		}

		if (Reflections.isPrimitive(realClass)) {

			if (formalClass.equals(Object.class)) {
				return 2;
			}

			else if (formalClass.equals(Number.class)) {
				return 1;
			}

			int d = Reflections.getPrimitiveTypeDistance(realClass, formalClass);
			if (d > 0) {
				return 100 * d;
			} else {
				return -d;
			}

		} else if (!Reflections.isExtends(formalClass, realClass)) {
			return Integer.MAX_VALUE;
		} else if (formalClass.isInterface()) {
			return 100;

		} else {
			int distance = 0;
			Class<?> arg = realClass;
			while (arg != formalClass) {
				distance++;
				arg = arg.getSuperclass();
			}
			return distance;
		}

	}

	public static Object getDefault(Class<?> cls) {

		if (Reflections.isPrimitive(cls)) {
			return ConvertUtils.convert("", cls);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static void getMethodsWithoutObject(Class<?> declare, Set<Method> methods) {

		if (!declare.isInterface() && declare.getModifiers() != Modifier.ABSTRACT) {

			Class<?> cls = declare;
			while (cls != Object.class) {

				methods.addAll(Arrays.asList(cls.getDeclaredMethods()));

				cls = cls.getSuperclass();
			}

		} else {

			methods.addAll(Arrays.asList(declare.getDeclaredMethods()));

			while (declare.getSuperclass() != null && declare.getSuperclass() != Object.class) {
				getMethodsWithoutObject(declare.getSuperclass(), methods);
			}

			for (Class<?> iCls : declare.getInterfaces()) {
				getMethodsWithoutObject(iCls, methods);
			}

		}
	}

	public static Method[] getMethodsWithoutObject(Class<?> declare) {

		HashSet<Method> methods = new HashSet<Method>();

		getMethodsWithoutObject(declare, methods);

		Method[] ms = methods.toArray(new Method[methods.size()]);

		return ms;
	}

	/*
	 * return value: 0 : not relation -1 : method0 is super class method 1 :
	 * method1 is super class method
	 */
	public static int getMethodsOverride(Method method0, Method method1) {

		if (!method0.getName().equals(method1.getName())) {
			return 0;
		}

		if (!isExtends(method1.getDeclaringClass(), method0.getDeclaringClass())
				&& !isExtends(method0.getDeclaringClass(), method1.getDeclaringClass())) {
			return 0;
		}

		Class<?>[] declareTypes = method0.getParameterTypes();
		Class<?>[] parentTypes = method1.getParameterTypes();

		if (declareTypes.length != parentTypes.length) {
			return 0;
		}

		for (int i = 0; i < declareTypes.length; i++) {
			if (declareTypes[i] != parentTypes[i])
				return 0;
		}

		return isExtends(method0.getDeclaringClass(), method1.getDeclaringClass()) ? -1 : 1;

	}

	public static Method[] removeOvrrideMethods(Method[] methods) {

		List<Method> newMethods = new ArrayList<Method>();

		for (int i = 0; i < methods.length; i++) {

			Method method0 = methods[i];

			boolean found = false;

			for (int j = 0, size = newMethods.size(); j < size; j++) {

				Method method1 = newMethods.get(j);

				int cmp = getMethodsOverride(method0, method1);

				if (cmp == -1) {
					found = true;
					break;
				} else if (cmp == 1) {
					newMethods.set(j, method0);
					found = true;
					break;
				}
			}

			if (!found) {
				newMethods.add(method0);
			}
		}

		return newMethods.toArray(new Method[newMethods.size()]);
	}

	public final static ClassPool ASSIST_POOL = ClassPool.getDefault();

	private static Map<Class<?>, CtClass> classPaths = new WeakHashMap<Class<?>, CtClass>();

	public static synchronized CtClass getCtClass(Class<?> cls) throws NotFoundException {

		if (!classPaths.containsKey(cls)) {
			ASSIST_POOL.appendClassPath(new ClassClassPath(cls));
			classPaths.put(cls, null);
		}

		return ASSIST_POOL.get(cls.getName());
	}

	public static void appendAnnotation(CtClass ctClass, Class<?> annoClass) {

		ClassFile ccFile = ctClass.getClassFile();
		ConstPool constpool = ccFile.getConstPool();

		AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
		Annotation annot = new Annotation(annoClass.getName(), constpool);

		attr.addAnnotation(annot);

		ccFile.addAttribute(attr);
	}

	public static Class<?> getPrimitivePackageClass(Class<?> cls) {
		if (cls == boolean.class) {
			return Boolean.class;
		}
		if (cls == byte.class) {
			return Byte.class;
		}
		if (cls == char.class) {
			return Character.class;
		}
		if (cls == short.class) {
			return Short.class;
		}
		if (cls == int.class) {
			return Integer.class;
		}
		if (cls == float.class) {
			return Float.class;
		}
		if (cls == long.class) {
			return Boolean.class;
		}
		if (cls == double.class) {
			return Double.class;
		}

		return cls;
	}

	public static boolean castPrimitive(Boolean v) {
		return v;
	}

	public static byte castPrimitive(Byte v) {
		return v;
	}

	public static char castPrimitive(Character v) {
		return v;
	}

	public static short castPrimitive(Short v) {
		return v;
	}

	public static int castPrimitive(Integer v) {
		return v;
	}

	public static float castPrimitive(Float v) {
		return v;
	}

	public static long castPrimitive(Long v) {
		return v;
	}

	public static double castPrimitive(Double v) {
		return v;
	}

	public static Boolean castPrimitive(boolean v) {
		return v;
	}

	public static Byte castPrimitive(byte v) {
		return v;
	}

	public static Character castPrimitive(char v) {
		return v;
	}

	public static Short castPrimitive(short v) {
		return v;
	}

	public static Integer castPrimitive(int v) {
		return v;
	}

	public static Float castPrimitive(float v) {
		return v;
	}

	public static Long castPrimitive(long v) {
		return v;
	}

	public static Double castPrimitive(double v) {
		return v;
	}

	public static boolean isAllInterface(Class<?>[] superClasses) {

		for (Class<?> superClass : superClasses) {
			if (!superClass.isInterface())
				return false;
		}
		return true;
	}

	public static Object createProxy(ClassLoader loader, final InvokeHandler handler, final Class<?>[] superClasses) {

		if (isAllInterface(superClasses)) {
			return Proxy.newProxyInstance(loader, superClasses, new InvocationHandler() {

				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

					InvokeArgument arguments = new InvokeArgument(proxy, method, args);

					try {

						handler.preInvoke(arguments);

						Object result = handler.invoke(arguments);
						return handler.postInvoke(result, arguments);

					} catch (Throwable e) {
						throw new RuntimeException(e);
					}
				}
			});
		} else {
			return new ClassMaker(superClasses).newObject(handler);

		}
	}
}
