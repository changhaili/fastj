package net.fastj.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.fastj.lang.reflection.Reflections;

public class Collections {

	public static <T> T getFirstOrDefault(List<T> col, T defaultValue) {
		return col == null || col.isEmpty() ? defaultValue : col.get(0);
	}

	public static <T> T getFirstOrDefault(T[] col, T defaultValue) {
		return col == null || col.length == 0 ? defaultValue : col[0];
	}

	public static <T> T getFirstNotNull(@SuppressWarnings("unchecked") T... col) {

		for (T v : col) {
			if (v != null)
				return v;
		}

		return null;
	}

	public static boolean isNullOrEmpty(Map<?, ?> col) {
		return col == null || col.size() == 0;
	}

	public static <T> T getFirstOrDefault(Iterable<T> col, T defaultValue) {
		if (col == null)
			return defaultValue;

		Iterator<T> i = col.iterator();

		return i.hasNext() ? i.next() : defaultValue;

	}

	public static <K, V> V getOrDefault(Map<K, V> map, K key, V defaultValue) {
		return (map.containsKey(key)) ? map.get(key) : defaultValue;
	}

	private static boolean equalsObject(Object o1, Object o2) {
		if (o1 == o2)
			return true;
		if (o1 == null)
			return false;

		return o1.equals(o2);
	}

	@SuppressWarnings("rawtypes")
	public static boolean contains(Object col, Object v) {

		if (col instanceof Object[]) {

			for (Object v2 : (Object[]) col) {
				if (equalsObject(v, v2))
					return true;
			}

		} else if (Reflections.isArray(col)) {
			int size = Array.getLength((Array) col);
			for (int i = 0; i < size; i++) {
				if (equalsObject(v, Array.get((Array) col, i)))
					return true;
			}

			return false;
		} else if (col instanceof Set) {
			return ((Set) col).contains(v);

		} else if (col instanceof Map) {
			return ((Map) col).containsKey(v);
		} else if (col instanceof Iterable) {

			for (Object i : (Iterable) col) {
				if (equalsObject(v, i))
					return true;
			}
			return false;
		} else if (col instanceof Iterator) {

			while (((Iterator) col).hasNext()) {
				if (equalsObject(v, ((Iterator) col).next()))
					return true;
			}
		} else if (col instanceof Enumeration) {

			while (((Enumeration) col).hasMoreElements()) {
				if (equalsObject(v, ((Enumeration) col).nextElement()))
					return true;
			}
		}

		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object[] toArray(Object v) {

		if (v instanceof Object[]) {
			return (Object[]) v;
		}

		else if (Reflections.isArray(v)) {

			Object[] vs = new Object[Array.getLength(v)];
			for (int i = 0; i < vs.length; i++) {
				vs[i] = Array.get(v, i);
			}

			return vs;
		} else if (v instanceof Collection) {
			return ((Collection) v).toArray();
		} else if (v instanceof Enumeration) {

			return java.util.Collections.list((Enumeration) v).toArray();

		} else if (v instanceof Iterable) {

			return toArray(((Iterable) v).iterator());

		} else if (v instanceof Iterator) {

			ArrayList list = new ArrayList();

			while (((Iterator) v).hasNext()) {
				list.add(((Iterator) v).next());
			}
			return list.toArray();
		} else {
			return new Object[] { v };
		}
	}

}
