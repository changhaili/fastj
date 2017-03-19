package net.fastj.lang.result;

import net.fastj.lang.mmodel.MModelContext;

public class CustomerResult extends AbstractResult {

	private final MModelContext datums;

	private final String name;

	public CustomerResult(MModelContext datums, String name) {

		this.datums = datums;
		this.name = name;
	}

	@Override
	public Object get() {
		return this.datums.getValue(this.name);
	}

	@Override
	public void set(Object value) {
		this.datums.putCustomer(this.name, value);
	}

}
