package net.fastj.collection;

public interface KeyValueGetter<K, V> {

	boolean contains(K k);

	V get(K k);
}
