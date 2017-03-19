package net.fastj.lang.result;

import net.fastj.lang.LangException;
import net.fastj.lang.mmodel.MModelContext;

public class IDResult extends AbstractResult {

	private final MModelContext datums;

	private final String name;

	public IDResult(MModelContext datums, String name) {

		this.datums = datums;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Object get() {

		if (this.datums.contains(this.name)) {
			return this.datums.getValue(this.name);
		}

		throw new LangException("can not found the variable " + this.name);
	}
}
