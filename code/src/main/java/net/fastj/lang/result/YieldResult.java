package net.fastj.lang.result;

public class YieldResult extends AbstractResult {

	public final static YieldResult INSTANCE = new YieldResult();

	private YieldResult() {

	}

	@Override
	public Object get() {

		return null;
	}
}
