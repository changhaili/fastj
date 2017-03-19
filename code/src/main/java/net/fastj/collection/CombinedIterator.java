package net.fastj.collection;

import java.util.Iterator;

import edu.emory.mathcs.backport.java.util.Arrays;

public class CombinedIterator<T> implements Iterator<T> {

	Iterator<Iterable<T>> sources = null;

	@SuppressWarnings("unchecked")
	public CombinedIterator(Iterable<T>... sources) {
		this.sources = Arrays.asList(sources).iterator();
	}

	public CombinedIterator(Iterable<Iterable<T>> sources) {
		this.sources = sources.iterator();
	}

	Iterator<T> values;

	@Override
	public boolean hasNext() {

		while (values == null || !values.hasNext()) {

			if (!this.sources.hasNext())
				return false;

			Iterable<T> iterable = this.sources.next();

			if (iterable == null) {
				return false;
			}
			values = iterable.iterator();
		}

		return true;

	}

	@Override
	public T next() {
		return this.values.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove");
	}

}
