package net.fastj.lang.invoker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import edu.emory.mathcs.backport.java.util.Arrays;
import net.fastj.LangEnginers;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.reflection.InvokeArgument;
import net.fastj.lang.reflection.InvokeHandler;
import net.fastj.lang.reflection.Reflections;

public class ExtensionsInvoker extends MethodInvoker {

	public ExtensionsInvoker(String methodName, MModelContext context) {

		super(null, null, methodName, context);
		this.parent = this;
		this.declare = this.getClass();
	}

	public int[] range(int begin, int count) {

		int[] a = new int[count];
		for (int i = 0; i < count; i++) {
			a[i] = begin + i;
		}

		return a;
	}

	public Object[] array(Object... args) {
		return args;
	}

	public Object newArray(Class<?> componentType, int length) {
		return Array.newInstance(componentType, length);
	}

	public int length(Object[] objs) {

		if (objs == null)
			return 0;

		return objs.length;
	}

	public int length(@SuppressWarnings("rawtypes") Iterable objs) {

		if (objs == null)
			return 0;

		return CollectionUtils.size(objs);
	}

	public Object sum(Object[] objs) {

		if (objs == null)
			return 0;

		Object s = 0;
		for (Object obj : objs) {
			s = new OperatorInvoker(this.context, "+", new Object[] { s, obj }).invoke().get();
		}

		return s;

	}

	public Object sum(@SuppressWarnings("rawtypes") Iterable objs) {

		if (objs == null)
			return 0;

		Object s = 0;
		for (Object obj : objs) {
			s = new OperatorInvoker(this.context, "+", new Object[] { s, obj }).invoke().get();
		}
		return s;
	}

	public Object avg(Object[] objs) {

		if (objs == null || objs.length == 0)
			return 0;

		return new OperatorInvoker(this.context, "/", new Object[] { sum(objs), objs.length }).invoke().get();

	}

	public Object avg(@SuppressWarnings("rawtypes") Iterable objs) {

		if (objs == null)
			return 0;

		Object sum = 0;
		int count = 0;
		for (Object obj : objs) {

			sum = new OperatorInvoker(this.context, "+", new Object[] { sum, obj }).invoke().get();
			count++;
		}
		return count == 0 ? 0 : new OperatorInvoker(this.context, "/", new Object[] { sum, count }).invoke().get();
	}

	public Object first(Object[] objs) {
		if (objs == null || objs.length == 0)
			return null;

		return objs[0];
	}

	public Object first(@SuppressWarnings("rawtypes") Iterable objs) {
		return firstOrDefault(objs, null);
	}

	public Object firstOrDefault(Object[] objs, Object defaultValue) {

		if (objs == null || objs.length == 0)
			return defaultValue;

		return objs[0];
	}

	public Object firstOrDefault(@SuppressWarnings("rawtypes") Iterable objs, Object defaultValue) {
		if (objs == null)
			return defaultValue;

		try {
			return CollectionUtils.get(objs, 0);
		} catch (Exception ex) {
			return defaultValue;
		}
	}

	@MethodAliases(aliases = { "assert" })
	public void assertTrue(boolean b) throws LangException {
		if (!b)
			throw new LangException();
	}

	@MethodAliases(aliases = { "assert" })
	public void assertTrue(boolean b, String message) throws LangException {
		if (!b)
			throw new LangException(message);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List list(Object... args) {
		return new ArrayList(Arrays.asList(args));
	}

	public FileBuffered readfile(String file) {
		return new FileBuffered(file);
	}

	public Object toType(Object obj, Class<?> cls) {

		return ConvertUtils.convert(obj, cls);

	}

	public boolean toBoolean(Object obj) {
		return (Boolean) ConvertUtils.convert(obj, Boolean.class);
	}

	public byte toByte(Object obj) {
		return (Byte) ConvertUtils.convert(obj, Byte.class);
	}

	public char toChar(Object obj) {
		return (Character) ConvertUtils.convert(obj, Character.class);
	}

	public short toShort(Object obj) {
		return (Short) ConvertUtils.convert(obj, Short.class);
	}

	public int toInt(Object obj) {
		return (Integer) ConvertUtils.convert(obj, Integer.class);
	}

	public long toLong(Object obj) {
		return (Long) ConvertUtils.convert(obj, Long.class);
	}

	public float toFloat(Object obj) {
		return (Float) ConvertUtils.convert(obj, Float.class);
	}

	public double toDouble(Object obj) {
		return (Double) ConvertUtils.convert(obj, Double.class);
	}

	public String toStr(Object obj) {
		return String.valueOf(obj);
	}

	public String stringf(String format, Object[] values) {
		return MessageFormat.format(format, values);
	}

	public Date now() {
		return new Date();
	}

	public Object include(String path) throws IOException {

		String text = FileUtils.readFileToString(new File(path));

		LangNode node = LangEnginers.parseCode(text, this.context);

		return LangUtils.toValue(node, this.context);
	}

	@MethodAliases(aliases = { "import" })
	public void __import(String name) {
		this.context.imports(name);
	}

	public Object eval(String expr) {

		LangNode node = LangEnginers.parseSimpleExpr(expr, this.context);
		return LangUtils.toValue(node, this.context);
	}

	public void println(String format, Object... args) {
		this.context.getGlobal().getPrinter()
				.println(MessageFormat.format(format, (Object[]) DynamicObject.toString(args, context)));
	}

	public void println(Object obj) {
		this.context.getGlobal().getPrinter().println(DynamicObject.toString(obj, context));
	}

	public void println() {
		this.context.getGlobal().getPrinter().println("");
	}

	public void print(String format, Object... args) {
		this.context.getGlobal().getPrinter()
				.print(MessageFormat.format(format, (Object[]) DynamicObject.toString(args, context)));
	}

	public void print(Object obj) {
		this.context.getGlobal().getPrinter().print(String.valueOf(obj));

	}

	public ProcessResult system(String cmd) {

		try {
			Process process = Runtime.getRuntime().exec(cmd);

			String input = IOUtils.toString(process.getInputStream());
			String error = IOUtils.toString(process.getErrorStream());

			int code = process.exitValue();

			return new ProcessResult(input, error, code);

		} catch (IOException e) {
			throw new LangException(e);
		}
	}

	public void exit(int code) {
		System.exit(code);
	}

	public Object invoke(Object parent, String method, Object[] args) {
		return InvokeUtils.invokeMethod(parent, parent.getClass(), method, this.context, args).get();

	}

	public Object invokeStatic(Class<?> declare, String method, Object[] args) {
		return InvokeUtils.invokeMethod(null, declare, method, this.context, args).get();
	}

	public Object createProxy(final DynamicObject handler, Class<?>... superClasses) {

		return Reflections.createProxy(handler.getClass().getClassLoader(), new InvokeHandler() {

			@Override
			public Object invoke(InvokeArgument arg) {

				if (handler.isFunction(arg.getMethodName())) {
					return handler.invokeFunction(arg.getMethodName(), context, arg.getArgs());
				} else if (arg.isInvokable()) {
					return arg.invoke();
				}
				return DynamicObject.dispatch(handler, context, arg.getArgs());
			}

		}, superClasses);

	}

}
