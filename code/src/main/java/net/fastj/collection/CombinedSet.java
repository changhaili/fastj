package net.fastj.collection;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CombinedSet<T> extends AbstractSet<T> {

	private Iterable<T>[] sets;

	@SafeVarargs
	@SuppressWarnings("unchecked")
	public CombinedSet(Set<T>... sets) {

		this.sets = new Iterable[sets.length + 1];

		this.sets[0] = new HashSet<T>();

		for (int i = 0; i < sets.length; i++) {
			this.sets[i + 1] = sets[i];
		}
	}

	@SuppressWarnings("unchecked")
	public CombinedSet(Iterable<Set<T>> col) {

		ArrayList<Iterable<T>> list = new ArrayList<Iterable<T>>();

		list.add(new HashSet<T>());

		list.addAll((Collection<? extends Iterable<T>>) col);

		this.sets = list.toArray(new Iterable[list.size()]);
	}

	@Override
	public Iterator<T> iterator() {
		return new CombinedIterator<T>(this.sets);
	}

	@Override
	public int size() {

		int count = 0;
		for (Iterable<T> set : this.sets) {
			count += ((Set<T>) set).size();
		}

		return count;
	}

	Set<T> findSet(Object o) {

		for (Iterable<T> set : this.sets) {

			if (((Set<T>) set).contains(o))
				return (Set<T>) set;
		}

		return null;
	}

	@Override
	public boolean contains(Object o) {

		return findSet(o) != null;

	}

	@Override
	public boolean remove(Object o) {

		return ((Set<T>) this.sets[0]).remove(o);
	}

	@Override
	public boolean add(T e) {
		return ((Set<T>) this.sets[0]).add(e);
	}

}
