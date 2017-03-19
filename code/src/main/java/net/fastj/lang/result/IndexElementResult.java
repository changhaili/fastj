package net.fastj.lang.result;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import net.fastj.lang.LangException;
import net.fastj.lang.reflection.Reflections;

public class IndexElementResult extends AbstractResult {

	private final Object collection;

	private final int index;

	public IndexElementResult(Object collection, int index) {

		this.collection = collection;
		this.index = index;
	}

	@Override
	public Object get() {

		return CollectionUtils.get(this.collection, index);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void set(Object value) {

		if (this.collection instanceof Object[]) {
			((Object[]) this.collection)[this.index] = value;
		} else if (this.collection instanceof List) {
			((List) this.collection).set(this.index, value);
		} else if (Reflections.isArray(this.collection)) {
			Array.set(this.collection, this.index, value);
		} else {
			throw new LangException("do not support set index");
		}
	}

}
