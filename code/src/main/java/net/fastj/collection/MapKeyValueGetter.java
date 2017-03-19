package net.fastj.collection;

import java.util.Map;

public class MapKeyValueGetter<K, V> implements KeyValueGetter<K, V> {

	private final Map<K, V> values;

	public MapKeyValueGetter(Map<K, V> values) {
		this.values = values;
	}

	@Override
	public V get(K key) {
		return this.values.get(key);
	}

	public Map<K, V> getValues() {
		return values;
	}

	@Override
	public boolean contains(K key) {
		return this.values.containsKey(key);
	}

}
