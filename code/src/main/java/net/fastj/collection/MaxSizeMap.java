package net.fastj.collection;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MaxSizeMap<K, V> extends IterableMap<K, V> {

	private static class Key<K> implements Comparable<Key<K>> {

		long index;

		K key;

		Comparator<K> comparator;

		public Key(long index, K key, Comparator<K> comparator) {

			this.index = index;
			this.key = key;
			this.comparator = comparator;
		}

		@Override
		public int hashCode() {
			return ((int) this.index) ^ key.hashCode();
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			return this.compareTo((Key<K>) obj) == 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public int compareTo(Key<K> o) {

			if (o == null)
				return -1;

			if (o == this)
				return 0;

			if (index > o.index)
				return 1;
			else if (index < o.index)
				return -1;

			if (this.comparator != null) {
				return this.comparator.compare(this.key, (K) (o.key));
			} else {
				return ((Comparable<K>) (this.key)).compareTo(o.key);
			}
		}
	}

	@SuppressWarnings("hiding")
	private class Value<V> {

		long index;

		V value;

		public Value(long index, V value) {
			this.index = index;
			this.value = value;
		}
	}

	private int capacity;

	private TreeMap<Key<K>, Value<V>> keys = null;

	private TreeMap<K, Value<V>> values = null;

	private Comparator<K> comparator = null;

	private long currentIndex = 0;

	public MaxSizeMap(int capacity) {
		this.capacity = capacity;

		this.keys = new TreeMap<Key<K>, Value<V>>();
		this.values = new TreeMap<K, Value<V>>();
	}

	public MaxSizeMap(int capacity, Comparator<K> comparator) {
		this.capacity = capacity;
		this.comparator = comparator;

		this.keys = new TreeMap<Key<K>, Value<V>>();
		this.values = new TreeMap<K, Value<V>>(comparator);
	}

	@Override
	public V put(K key, V value) {

		long now = this.currentIndex++;

		Key<K> newKey = new Key<K>(now, key, this.comparator);
		Value<V> newValue = new Value<V>(now, value);

		if (this.values.containsKey(key)) {

			Value<V> oldValue = this.values.get(key);

			Key<K> oldKey = new Key<K>(oldValue.index, key, this.comparator);

			this.keys.remove(oldKey);

			this.keys.put(newKey, newValue);
			this.values.put(key, newValue);

			return oldValue.value;

		} else {

			if (this.keys.size() == this.capacity) {
				Key<K> k = this.keys.firstKey();
				this.keys.remove(k);
				this.values.remove(k.key);
			}

			this.keys.put(newKey, newValue);
			this.values.put(key, newValue);

			return null;
		}
	}

	@Override
	public void clear() {

		this.keys.clear();
		this.values.clear();
		this.currentIndex = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		if (!this.containsKey(key))
			return null;

		Value<V> v = this.values.get(key);

		this.keys.remove(new Key<K>(v.index, (K) key, this.comparator));
		this.values.remove(key);

		return v.value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (java.util.Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public int size() {
		return this.keys.size();
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean isFull() {
		return this.size() == this.getCapacity();
	}

	@Override
	public V get(Object key) {
		return this.values.get(key).value;
	}

	@Override
	public boolean containsKey(Object key) {
		return this.values.containsKey(key);
	}

	@Override
	public Set<K> keySet() {
		return this.values.keySet();
	}

	public Set<K> sequenceKeySet() {

		return new AbstractSet<K>() {

			@Override
			public Iterator<K> iterator() {

				final Iterator<Key<K>> i = keys.keySet().iterator();

				return new Iterator<K>() {

					Key<K> _next = null;

					@Override
					public boolean hasNext() {
						return i.hasNext();
					}

					@Override
					public K next() {

						_next = i.next();
						return _next.key;
					}

					@Override
					public void remove() {
						i.remove();
						values.remove(_next.key);
					}
				};
			}

			@Override
			public int size() {
				return keys.size();
			}
		};

	}

	@Override
	public Iterator<java.util.Map.Entry<K, V>> iterator() {

		final Iterator<Map.Entry<K, Value<V>>> i = values.entrySet().iterator();

		return new Iterator<Map.Entry<K, V>>() {

			Map.Entry<K, Value<V>> _next = null;

			@Override
			public boolean hasNext() {
				return i.hasNext();
			}

			@Override
			public java.util.Map.Entry<K, V> next() {

				_next = i.next();
				return newEntry(_next.getKey(), _next.getValue().value);

			}

			@Override
			public void remove() {

				i.remove();
				keys.remove(new Key<K>(_next.getValue().index, _next.getKey(), comparator));
			}
		};

	}
}
