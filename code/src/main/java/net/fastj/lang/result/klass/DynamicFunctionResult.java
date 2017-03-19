package net.fastj.lang.result.klass;

import net.fastj.lang.DynamicObject;
import net.fastj.lang.result.TokenResult;

public class DynamicFunctionResult extends TokenResult {

	private final DynamicObject parent;

	private final String name;

	public DynamicFunctionResult(DynamicObject parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public DynamicObject getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}
	

}