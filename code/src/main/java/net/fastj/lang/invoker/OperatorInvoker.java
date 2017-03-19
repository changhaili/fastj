package net.fastj.lang.invoker;

import java.text.MessageFormat;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.backport.java.util.Arrays;
import net.fastj.lang.DynamicObject;
import net.fastj.lang.LangException;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.EmptyResult;
import net.fastj.lang.result.ExceptionResult;
import net.fastj.lang.result.Result;

public class OperatorInvoker {

	public final static Logger LOGGER = LoggerFactory.getLogger(OperatorInvoker.class);

	private final MModelContext context;
	private final String method;

	private final Object[] realArgs;

	public OperatorInvoker(MModelContext context, String method, Object[] realArgs) {
		super();
		this.context = context;
		this.method = method;
		this.realArgs = realArgs;
	}

	public Result invoke() {

		if (realArgs == null || realArgs.length == 0) {
			throw new LangException("real parameters can not be empty");
		}

		try {

			Result result = InvokeUtils.invokeMethod(this, OperatorInvoker.class, method, context, realArgs);

			if (!(result instanceof EmptyResult) && !(result instanceof ExceptionResult)) {
				return result;
			}
		} catch (Exception ex) {
			LOGGER.debug(ex.getMessage(), ex);
		}

		Object parent = realArgs[0];

		Object[] lastArgs = Arrays.copyOfRange(realArgs, 1, realArgs.length);

		if (parent == null) {
			throw new RuntimeException("the first parameter is null!");
		}

		return InvokeUtils.invokeMethod(parent, parent.getClass(), method, context, lastArgs);

	}

	// positive

	@MethodAliases(aliases = { "+" })
	public byte positive(byte v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public char positive(char v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public short positive(short v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public int positive(int v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public long positive(long v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public float positive(float v) {
		return v;
	}

	@MethodAliases(aliases = { "+" })
	public double positive(double v) {
		return v;
	}

	// negative

	@MethodAliases(aliases = { "-" })
	public int negative(int v) {
		return -v;
	}

	@MethodAliases(aliases = { "-" })
	public long negative(long v) {
		return -v;
	}

	@MethodAliases(aliases = { "-" })
	public float negative(float v) {
		return -v;
	}

	@MethodAliases(aliases = { "-" })
	public double negative(double v) {
		return -v;
	}

	// plusplus

	@MethodAliases(aliases = { "++" })
	public byte plusplus(byte v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public char plusplus(char v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public short plusplus(short v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public int plusplus(int v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public long plusplus(long v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public float plusplus(float v) {
		return ++v;
	}

	@MethodAliases(aliases = { "++" })
	public double plusplus(double v) {
		return ++v;
	}

	// minusminus

	@MethodAliases(aliases = { "--" })
	public byte minusminus(byte v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public char minusminus(char v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public short minusminus(short v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public int minusminus(int v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public long minusminus(long v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public float minusminus(float v) {
		return --v;
	}

	@MethodAliases(aliases = { "--" })
	public double minusminus(double v) {
		return --v;
	}

	// Power

	@MethodAliases(aliases = { "**" })
	public double power(double a, double b) {
		return Math.pow(a, b);
	}

	// Multi
	@MethodAliases(aliases = { "*" })
	public int multi(int a, int b) {
		return a * b;
	}

	@MethodAliases(aliases = { "*" })
	public long multi(long a, long b) {
		return a * b;
	}

	@MethodAliases(aliases = { "*" })
	public float multi(float a, float b) {
		return a * b;
	}

	@MethodAliases(aliases = { "*" })
	public double multi(double a, double b) {
		return a * b;
	}

	@MethodAliases(aliases = { "*" })
	public String power(String a, int b) {

		if (b == 1)
			return a;

		if (b == 2)
			return a + a;

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < b; i++) {
			builder.append(a);
		}

		return builder.toString();

	}

	// DIV

	@MethodAliases(aliases = { "/" })
	public int div(int a, int b) {
		return a / b;
	}

	@MethodAliases(aliases = { "/" })
	public long div(long a, long b) {
		return a / b;
	}

	@MethodAliases(aliases = { "/" })
	public float div(float a, float b) {
		return a / b;
	}

	@MethodAliases(aliases = { "/" })
	public double div(double a, double b) {
		return a % b;
	}

	// MODE

	@MethodAliases(aliases = { "%" })
	public int mode(int a, int b) {
		return a % b;
	}

	@MethodAliases(aliases = { "%" })
	public long mode(long a, long b) {
		return a % b;
	}

	@MethodAliases(aliases = { "%" })
	public float mode(float a, float b) {
		return a % b;
	}

	@MethodAliases(aliases = { "%" })
	public double mode(double a, double b) {
		return a % b;
	}

	@MethodAliases(aliases = { "%" })
	public String mode(String a, Object[] b) {

		return MessageFormat.format(a, b);
	}

	// PLUS

	@MethodAliases(aliases = { "+" })
	public int plus(int a, int b) {
		return a + b;
	}

	@MethodAliases(aliases = { "+" })
	public long plus(long a, long b) {
		return a + b;
	}

	@MethodAliases(aliases = { "+" })
	public float plus(float a, float b) {
		return a + b;
	}

	@MethodAliases(aliases = { "+" })
	public double plus(double a, double b) {
		return a + b;
	}

	@MethodAliases(aliases = { "+" })
	public String plus(String a, Object b) {
		return a + DynamicObject.toString(b, context);
	}

	@MethodAliases(aliases = { "+" })
	public String plus(Object a, String b) {
		return DynamicObject.toString(a, context) + b;
	}

	// MINUS

	@MethodAliases(aliases = { "-" })
	public int minus(int a, int b) {
		return a - b;
	}

	@MethodAliases(aliases = { "-" })
	public long minus(long a, long b) {
		return a - b;
	}

	@MethodAliases(aliases = { "-" })
	public float minus(float a, float b) {
		return a - b;
	}

	@MethodAliases(aliases = { "-" })
	public double minus(double a, double b) {
		return a - b;
	}

	// leftShift

	@MethodAliases(aliases = { "<<" })
	public int leftShift(int a, int b) {
		return a << b;
	}

	@MethodAliases(aliases = { "<<" })
	public long leftShift(long a, long b) {
		return a << b;
	}

	// rightShift

	@MethodAliases(aliases = { ">>" })
	public int rightShift(int a, int b) {
		return a >> b;
	}

	@MethodAliases(aliases = { ">>" })
	public long rightShift(long a, long b) {
		return a >> b;
	}

	// rightRotate

	@MethodAliases(aliases = { ">>>" })
	public int rightRotate(int a, int b) {
		return a >>> b;
	}

	@MethodAliases(aliases = { ">>>" })
	public long rightRotate(long a, long b) {
		return a >>> b;
	}

	// gt

	@MethodAliases(aliases = { ">" })
	public boolean gt(int a, int b) {
		return a > b;
	}

	@MethodAliases(aliases = { ">" })
	public boolean gt(long a, long b) {
		return a > b;
	}

	@MethodAliases(aliases = { ">" })
	public boolean gt(double a, double b) {
		return a > b;
	}

	// ge

	@MethodAliases(aliases = { ">" })
	public boolean ge(int a, int b) {
		return a >= b;
	}

	@MethodAliases(aliases = { ">" })
	public boolean ge(long a, long b) {
		return a >= b;
	}

	@MethodAliases(aliases = { ">" })
	public boolean ge(double a, double b) {
		return a >= b;
	}

	// lt

	@MethodAliases(aliases = { "<" })
	public boolean lt(int a, int b) {
		return a < b;
	}

	@MethodAliases(aliases = { "<" })
	public boolean lt(long a, long b) {
		return a < b;
	}

	@MethodAliases(aliases = { "<" })
	public boolean lt(double a, double b) {
		return a < b;
	}

	// le

	@MethodAliases(aliases = { "<=" })
	public boolean le(int a, int b) {
		return a <= b;
	}

	@MethodAliases(aliases = { "<=" })
	public boolean le(long a, long b) {
		return a <= b;
	}

	@MethodAliases(aliases = { "<=" })
	public boolean le(double a, double b) {
		return a <= b;
	}

	// refEquals

	@MethodAliases(aliases = { "==" })
	public boolean refEquals(boolean a, boolean b) {
		return a == b;
	}

	@MethodAliases(aliases = { "==" })
	public boolean refEquals(int a, int b) {
		return a == b;
	}

	@MethodAliases(aliases = { "==" })
	public boolean refEquals(long a, long b) {
		return a == b;
	}

	@MethodAliases(aliases = { "==" })
	public boolean refEquals(double a, double b) {
		return a == b;
	}

	@MethodAliases(aliases = { "==" })
	public boolean refEquals(Object a, Object b) {
		return a == b;
	}

	// refNotEquals

	@MethodAliases(aliases = { "!=" })
	public boolean refNotEquals(boolean a, boolean b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!=" })
	public boolean refNotEquals(int a, int b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!=" })
	public boolean refNotEquals(long a, long b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!=" })
	public boolean refNotEquals(double a, double b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!=" })
	public boolean refNotEquals(Object a, Object b) {
		return a != b;
	}

	// equals

	@MethodAliases(aliases = { "===" })
	public boolean equals(boolean a, boolean b) {
		return a == b;
	}

	@MethodAliases(aliases = { "===" })
	public boolean equals(int a, int b) {
		return a == b;
	}

	@MethodAliases(aliases = { "===" })
	public boolean equals(long a, long b) {
		return a == b;
	}

	@MethodAliases(aliases = { "===" })
	public boolean equals(double a, double b) {
		return a == b;
	}

	@MethodAliases(aliases = { "===" })
	public boolean equals(Object a, Object b) {

		if (a == b) {
			return true;
		}

		if (a == null && b == null)
			return false;
		return a.equals(b);
	}

	// notEquals

	@MethodAliases(aliases = { "!==" })
	public boolean notEquals(boolean a, boolean b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!==" })
	public boolean notEquals(int a, int b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!==" })
	public boolean notEquals(long a, long b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!==" })
	public boolean notEquals(double a, double b) {
		return a != b;
	}

	@MethodAliases(aliases = { "!==" })
	public boolean notEquals(Object a, Object b) {
		return !equals(a, b);
	}

	// not
	@MethodAliases(aliases = { "~" })
	public int not(int v) {
		return ~v;
	}

	@MethodAliases(aliases = { "~" })
	public long not(long v) {
		return ~v;
	}

	// and

	@MethodAliases(aliases = { "&" })
	public boolean and(boolean a, boolean b) {
		return a & b;
	}

	@MethodAliases(aliases = { "&" })
	public int and(int a, int b) {
		return a & b;
	}

	@MethodAliases(aliases = { "&" })
	public long and(long a, long b) {
		return a & b;
	}

	// xor

	@MethodAliases(aliases = { "^" })
	public boolean xor(boolean a, boolean b) {
		return a ^ b;
	}

	@MethodAliases(aliases = { "^" })
	public int xor(int a, int b) {
		return a ^ b;
	}

	@MethodAliases(aliases = { "^" })
	public long xor(long a, long b) {
		return a ^ b;
	}

	// or

	@MethodAliases(aliases = { "|" })
	public boolean or(boolean a, boolean b) {
		return a | b;
	}

	@MethodAliases(aliases = { "|" })
	public int or(int a, int b) {
		return a | b;
	}

	@MethodAliases(aliases = { "|" })
	public long or(long a, long b) {
		return a | b;
	}

	// boolNot

	@MethodAliases(aliases = { "!" })
	public boolean boolNot(boolean v) {
		return !v;
	}

	// boolAnd

	@MethodAliases(aliases = { "&&" })
	public boolean boolAnd(boolean a, boolean b) {
		return a && b;
	}

	// boolOr

	@MethodAliases(aliases = { "||" })
	public boolean boolOr(boolean a, boolean b) {
		return a || b;
	}

	// nullOr

	@MethodAliases(aliases = { "??" })
	public Object nullOr(Object a, Object b) {
		return a == null ? b : a;
	}

	// PatternMatcher

	@MethodAliases(aliases = { "~=" })
	public boolean match(String a, String regex) {
		return Pattern.compile(regex).matcher(a).matches();
	}
}
