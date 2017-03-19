package net.fastj.collection;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class IterableMap<K, V> extends AbstractMap<K, V> implements Iterable<Map.Entry<K, V>> {

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {

		return new AbstractSet<Map.Entry<K, V>>() {

			@Override
			public Iterator<java.util.Map.Entry<K, V>> iterator() {
				return IterableMap.this.iterator();
			}

			@Override
			public int size() {
				return IterableMap.this.size();
			}

		};
	}

	@Override
	public int size() {

		int count = 0;

		Iterator<java.util.Map.Entry<K, V>> i = this.iterator();
		while (i.hasNext())
			count++;

		return count;
	}

	protected Map.Entry<K, V> newEntry(K k, V v) {
		return new SimpleEntry<K, V>(k, v);
	}

}
