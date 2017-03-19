package net.fastj.lang.result;

import net.fastj.lang.LangException;

public abstract class TokenResult extends AbstractResult {

	@Override
	public Object get() {
		throw new LangException("Token variable");
	}

}
