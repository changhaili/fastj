package net.fastj.lang.result.klass;

import net.fastj.lang.result.AbstractResult;

public class JavaKlassResult extends AbstractResult {

	private final Class<?> cls;

	public JavaKlassResult(Class<?> cls) {
		this.cls = cls;
	}

	public Class<?> getType() {
		return this.cls;
	}

	@Override
	public Object get() {
		return this.cls;
	}

}
