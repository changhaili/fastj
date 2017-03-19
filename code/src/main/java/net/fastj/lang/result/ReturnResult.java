package net.fastj.lang.result;

public class ReturnResult extends AbstractResult {

	private final Object value;

	public final static ReturnResult NULL = new ReturnResult(null);

	public ReturnResult(Object value) {

		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

	public static boolean isReturn(Object v) {
		return v instanceof ReturnResult;
	}

	public static Object getResult(Object v) {
		return isReturn(v) ? getResult(((ReturnResult) v).value) : v;
	}

	@Override
	public Object get() {
		return this.value;
	}

}
