package net.fastj.lang.invoker;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import net.fastj.Filter;
import net.fastj.collection.ArrayKey;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.LambdaNode;
import net.fastj.lang.LamdbaFunObject;
import net.fastj.lang.LangException;
import net.fastj.lang.mmodel.GlobalBlock;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.reflection.ClassMaker;
import net.fastj.lang.reflection.Reflections;
import net.fastj.lang.reflection.Reflections.ExecutableCallback;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.EmptyResult;
import net.fastj.lang.result.ExceptionResult;
import net.fastj.lang.result.Result;

public class InvokeUtils {

	public final static Logger LOGGER = LoggerFactory.getLogger(InvokeUtils.class);

	public static void appendMethod(GlobalBlock block, Method method, Object parent) {

		String name = method.getName();
		block.addMethod(name, new InvokeEvaluator(null, method.getDeclaringClass(), name));

		MethodAliases aliases = method.getAnnotation(MethodAliases.class);

		if (aliases != null) {

			for (String a : aliases.aliases()) {
				block.addMethod(a, new InvokeEvaluator(null, method.getDeclaringClass(), name));

			}
		}
	}

	public static void appendMethods(GlobalBlock block) {

		for (Method m : ReflectionUtils.getAllDeclaredMethods(Math.class)) {

			if ((m.getModifiers() & Modifier.STATIC) != 0) {

				String name = m.getName();

				block.addMethod(name, new InvokeEvaluator(null, Math.class, name));

			}
		}

		for (Method m : Reflections.getMethodsWithoutObject(ExtensionsInvoker.class)) {

			String name = m.getName();

			block.addMethod(name, new InvokeEvaluator(null, null, name) {
				@Override
				public MethodInvoker eval(MModelContext context) {
					return new ExtensionsInvoker(methodName, context);
				}
			});

		}

		block.addMethod("assert", new InvokeEvaluator(null, null, "assertTrue") {

			@Override
			public MethodInvoker eval(MModelContext context) {
				return new ExtensionsInvoker(this.methodName, context);
			}
		});

		block.addMethod("import", new InvokeEvaluator(null, null, "__import") {
			@Override
			public MethodInvoker eval(MModelContext context) {
				return new ExtensionsInvoker(this.methodName, context);
			}
		});

	}

	public static boolean hasFunctionAlias(Method method, String alias) {

		MethodAliases aliases = method.getAnnotation(MethodAliases.class);

		if (aliases != null) {
			for (String a : aliases.aliases()) {

				if (a.equals(alias)) {
					return true;
				}
			}
		}

		return false;
	}

	private static int getArgsDistance(RealParamType[] realTypes, Class<?>[] formalClasses, boolean hasVarArgs) {
		int totalDistance = 0;

		for (int i = 0; i < realTypes.length; i++) {

			RealParamType realType = realTypes[i];

			if (realType == null)
				continue;

			Class<?> formalClass = i > formalClasses.length - 1 ? formalClasses[formalClasses.length - 1]
					: formalClasses[i];

			int currentDistance = -1;

			// the last element
			if (realTypes.length == formalClasses.length && i == formalClasses.length - 1) {

				if (hasVarArgs && realType.isArray()) {
					currentDistance = Reflections.getArgDistance(realType.getComponentType(), formalClass);

				} else {
					currentDistance = realType.getDistanceTo(formalClass);
				}

			} else {

				if (realTypes[i].isArray()) {

					if (formalClass.isArray()) {
						currentDistance = Reflections.getArgDistance(realType.getComponentType(),
								formalClass.getComponentType());

					} else if (formalClass == Object.class) {
						currentDistance = 1000;
					} else {
						return Integer.MAX_VALUE;
					}
				} else {
					currentDistance = realType.getDistanceTo(formalClass);
				}

			}

			if (currentDistance == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}

			totalDistance += currentDistance;

		}

		return totalDistance;

	}

	private static Member[] getSatisfyExecutableMembers(Member[] members, RealParamType[] realTypes,
			Filter<Member> filter) {

		List<DefaultKeyValue> satisfys = new ArrayList<DefaultKeyValue>(members.length);

		for (Member member : members) {

			if (filter != null && !filter.isSatisfied(member)) {
				continue;
			}

			Class<?>[] pts = null;
			boolean hasVarArgs = false;
			if (member instanceof Method) {

				hasVarArgs = ((Method) member).isVarArgs();
				pts = ((Method) member).getParameterTypes();
			} else {
				hasVarArgs = ((Constructor<?>) member).isVarArgs();
				pts = ((Constructor<?>) member).getParameterTypes();
			}

			if (hasVarArgs) {
				if (pts.length > realTypes.length + 1) {
					continue;
				}

				pts[pts.length - 1] = pts[pts.length - 1].getComponentType();
			} else {
				if (pts.length != realTypes.length)
					continue;
			}

			int distance = getArgsDistance(realTypes, pts, hasVarArgs);
			if (distance == Integer.MAX_VALUE)
				continue;

			satisfys.add(new DefaultKeyValue(distance, member));

		}

		satisfys.sort(new Comparator<DefaultKeyValue>() {

			@Override
			public int compare(DefaultKeyValue o1, DefaultKeyValue o2) {
				return ((Integer) o1.getKey()).compareTo((Integer) o2.getKey());
			}
		});

		Member[] newMembers = new Member[satisfys.size()];

		for (int i = 0; i < newMembers.length; i++) {
			newMembers[i] = (Member) satisfys.get(i).getValue();
		}

		return newMembers;// satisfys.values().toArray(new
							// Member[satisfys.size()]);
	}

	private static Map<ArrayKey, Object> memberBuffers = new WeakHashMap<ArrayKey, Object>();

	private static Member[] getSatisfyMethods(Class<?> declareClass, final String methodName,
			RealParamType[] realTypes) {

		ArrayKey key = new ArrayKey(methodName, declareClass).addAll((Object[]) realTypes);

		synchronized (memberBuffers) {

			if (memberBuffers.containsKey(key)) {
				return (Member[]) memberBuffers.get(key);
			}
		}

		Method[] declareMethods = ReflectionUtils.getAllDeclaredMethods(declareClass);

		declareMethods = Reflections.removeOvrrideMethods(declareMethods);

		Member[] methods = getSatisfyExecutableMembers(declareMethods, realTypes, new Filter<Member>() {

			@Override
			public boolean isSatisfied(Member member) {
				return member.getName().equals(methodName) || hasFunctionAlias((Method) member, methodName);

			}
		});

		synchronized (memberBuffers) {
			memberBuffers.put(key, methods);
		}

		return methods;

	}

	private static Result invokeTopExecutable(Member[] members, Object parent, Object[] realArgs, MModelContext context,
			ExecutableCallback callback) {

		Exception ex = null;

		for (Member member : members) {

			try {

				boolean hasVarArgs = false;
				Class<?>[] ps = null;

				if (member instanceof Method) {
					ps = ((Method) member).getParameterTypes();
					hasVarArgs = ((Method) member).isVarArgs();
				} else {

					hasVarArgs = ((Constructor<?>) member).isVarArgs();
					ps = ((Constructor<?>) member).getParameterTypes();
				}

				Object result = null;

				if (hasVarArgs) {

					Object[] args = new Object[ps.length];
					for (int i = 0; i < ps.length - 1; i++) {
						args[i] = realArgs[i];
					}

					if (ps.length != realArgs.length || !Reflections.isArray(realArgs[realArgs.length - 1])) {

						int reservedLength = realArgs.length - ps.length + 1;
						Object last = Array.newInstance(ps[ps.length - 1].getComponentType(), reservedLength);

						for (int i = 0; i < reservedLength; i++) {
							Array.set(last, i, realArgs[args.length - 1 + i]);
						}

						args[args.length - 1] = last;
					}

					result = callback.invoke(member, parent, args);

				} else {
					result = callback.invoke(member, parent, realArgs);

				}

				return new ConstResult(result);

			} catch (Exception e) {
				ex = e;
				LOGGER.debug("call function error! " + member.toString(), e);

			}
		}

		if (ex == null) {
			return EmptyResult.INSTANCE;
		}

		return new ExceptionResult(ex);
	}

	public static Result invokeMethod(Object parent, Class<?> declareClass, final String methodName,
			MModelContext context, Object[] realArgs) {

		if (parent instanceof InvokeEvaluator) {
			parent = ((InvokeEvaluator) parent).eval(context);
			declareClass = parent.getClass();
		}

		RealParamType[] realTypes = RealParamType.getRealParamTypes(context, realArgs);

		Member[] methods = getSatisfyMethods(declareClass, methodName, realTypes);

		if (methods == null || methods.length == 0) {
			return EmptyResult.INSTANCE;
		}

		Object[] outputs = RealParamType.convertObjects(context, realTypes, realArgs);

		Result result = invokeTopExecutable(methods, parent, outputs, context, new ExecutableCallback() {

			@Override
			public Object invoke(Member method, Object... args) {
				try {

					((Method) method).setAccessible(true);
					return ((Method) method).invoke(args[0], (Object[]) args[1]);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		if (result instanceof ExceptionResult) {
			throw new LangException(((ExceptionResult) result).getException());
		}

		return result;
	}

	private static Member[] getSatisfyConstructors(Class<?> declareClass, RealParamType[] realTypes) {

		ArrayKey key = new ArrayKey("..", declareClass).addAll((Object[]) realTypes);

		synchronized (memberBuffers) {

			if (memberBuffers.containsKey(key)) {
				return (Member[]) memberBuffers.get(key);
			}
		}

		Member[] constructors = getSatisfyExecutableMembers(declareClass.getConstructors(), realTypes, null);

		synchronized (memberBuffers) {
			memberBuffers.put(key, constructors);
		}

		return constructors;

	}

	public static Result invokeConstructor(Class<?> declareClass, MModelContext context, Object[] realArgs) {

		RealParamType[] realTypes = RealParamType.getRealParamTypes(context, realArgs);

		Member[] constructors = getSatisfyConstructors(declareClass, realTypes);

		if (constructors == null || constructors.length == 0) {
			throw new LangException("not found constructor");
		}

		Object[] outputs = RealParamType.convertObjects(context, realTypes, realArgs);

		Result result = invokeTopExecutable(constructors, null, outputs, context, new ExecutableCallback() {

			@Override
			public Object invoke(Member constructor, Object... args) {

				try {
					return ((Constructor<?>) constructor).newInstance((Object[]) args[1]);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			}
		});

		if (result instanceof ExceptionResult) {
			throw new LangException(((ExceptionResult) result).getException());
		}

		return result;

	}

	private static final AtomicLong lamdaClassIndex = new AtomicLong();

	public static Object createJavaLambdaObject(LambdaNode lambda, Class<?> expectedClass, MModelContext context) {

		Class<?> cls = lambda.getDeclaredClass();
		if (cls == null) {
			cls = expectedClass;
		}

		String functionName = lambda.getFunctionName();
		FunctionNode oldFunction = lambda.getFunction();

		if (StringUtils.isBlank(functionName)) {

			for (Method method : ReflectionUtils.getAllDeclaredMethods(cls)) {
				if (Reflections.isAbstract(method) & method.getParameterCount() == oldFunction.getFormals().length) {
					functionName = method.getName();
					break;
				}
			}
		}

		FunctionNode f0 = new FunctionNode(lambda.getSource(), functionName, oldFunction.getFormals(),
				oldFunction.getSegments(), oldFunction.getDefaults());

		FunctionNode f1 = new FunctionNode(lambda.getSource(), "()", oldFunction.getFormals(),
				oldFunction.getSegments(), oldFunction.getDefaults());

		KlassNode node = new KlassNode(lambda.getSource(), "$Lambda$Auto$" + lamdaClassIndex.incrementAndGet(),
				new String[0], new LangNode[0], new FunctionNode[] { f0, f1 });

		DynamicObject handler = node.createObject(context, new Object[0]);

		Object obj = ClassMaker.createProxy(context, handler, cls, LamdbaFunObject.class);

		return obj;

	}
}
