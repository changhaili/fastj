package net.fastj.lang.result;

import net.fastj.lang.LangException;

public abstract class AbstractResult implements Result {

	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Result))
			return false;

		Result v = (Result) obj;

		try {

			Object o1 = this.get();
			Object o2 = v.get();

			if (o1 == o2)
				return true;

			if (o1 == null || o2 == null)
				return false;

			return o1.equals(o2);

		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public void set(Object value) {
		throw new LangException("can not set the variable new value");
	}

	@Override
	public String toString() {
		return String.valueOf(this.get());
	}

}
