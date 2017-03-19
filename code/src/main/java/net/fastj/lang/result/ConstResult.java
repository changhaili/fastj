package net.fastj.lang.result;

public class ConstResult extends AbstractResult {

	public final static ConstResult TRUE = new ConstResult(true);

	public final static ConstResult FALSE = new ConstResult(false);

	public final static ConstResult NULL = new ConstResult(null);

	private final Object value;

	public ConstResult(Object value) {
		this.value = value;
	}

	@Override
	public Object get() {
		return this.value;
	}

}
