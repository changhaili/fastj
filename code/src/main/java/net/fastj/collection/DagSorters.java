package net.fastj.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

public class DagSorters<T> {

	public static interface Dependence<T> {
		T[] getDependencies(T v);
	}

	public static class ComparatorSorter<T> {

		private T[] values;

		private Dependence<T> dependence;

		public ComparatorSorter(T[] values, Dependence<T> dependence) {
			this.values = values;
			this.dependence = dependence;

			this.initialize();
		}

		private Map<T, Integer> indices = new HashMap<T, Integer>();

		private int[][] comparators = null;

		private boolean geZero(int x) {
			return x == 1 || x == 0;
		}

		private boolean leZero(int x) {
			return x == -1 || x == 0;
		}

		private int compare(int a, int b) {

			if (this.comparators[a][b] != -2) {
				return this.comparators[a][b];
			}

			if (a == b || this.values[a].equals(this.values[b])) {

				this.comparators[a][b] = 0;
				this.comparators[b][a] = 0;
				return 0;
			}

			T[] as = dependence.getDependencies(this.values[a]);

			if (ArrayUtils.isNotEmpty(as)) {

				for (int i = 0; i < as.length; i++) {

					int na = this.indices.get(as[i]);

					if (na == b || geZero(compare(na, b))) {

						this.comparators[a][b] = 1;
						this.comparators[b][a] = -1;
						return 1;
					}
				}
			}

			T[] bs = dependence.getDependencies(this.values[b]);

			if (ArrayUtils.isNotEmpty(bs)) {

				for (int i = 0; i < bs.length; i++) {

					int nb = this.indices.get(bs[i]);

					if (a == nb || leZero(compare(a, nb))) {

						this.comparators[a][b] = -1;
						this.comparators[b][a] = 1;
						return -1;
					}
				}
			}

			return -2;
		}

		private void initialize() {

			int N = this.values.length;

			for (int i = 0; i < N; i++) {
				this.indices.put(values[i], i);
			}

			this.comparators = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (i != j)
						this.comparators[i][j] = -2;
				}
			}

			for (int i = 0; i < N - 1; i++) {

				for (int j = i + 1; j < N; j++) {

					if (this.comparators[i][j] == -2) {
						this.comparators[i][j] = this.compare(i, j);
					}
				}
			}
		}

		public T[] sort() {

			Arrays.sort(values, new Comparator<T>() {

				public int compare(T o1, T o2) {

					int i1 = indices.get(o1);
					int i2 = indices.get(o2);

					int c = ComparatorSorter.this.compare(i1, i2);// comparators[i1][i2];
					return c == -2 ? 0 : c;
				}
			});

			return this.values;
		}

		public T[] getValues() {
			return this.values;
		}

	}

	public static class BreadthSorter<T> {

		static class Item<T> {

			List<Item<T>> ins = new ArrayList<Item<T>>();
			int out;
			T value;
		}

		private ArrayList<Item<T>> items;

		private T[] values = null;

		public BreadthSorter(T[] values, Dependence<T> dependence) {

			this.values = values;

			Map<T, Item<T>> map = new HashMap<T, Item<T>>(values.length);

			for (T v : values) {

				Item<T> item = new Item<T>();
				item.value = v;

				map.put(v, item);
			}

			for (Item<T> v : map.values()) {

				T[] ds = dependence.getDependencies(v.value);

				v.out = ds == null ? 0 : ds.length;

				if (v.out != 0) {

					for (T d : ds) {

						map.get(d).ins.add(v);
					}
				}
			}

			this.items = new ArrayList<Item<T>>(map.values());
		}

		private void handleItem(Item<T> item) {

			for (Item<T> i : item.ins) {
				i.out -= 1;
			}
		}

		public T[] sort() {

			int i = 0;
			int j = 0;
			int size = items.size();

			while (true) {

				Item<T> item0 = null;

				for (; i < size - 1; i++) {

					item0 = items.get(i);

					if (item0.out == 0) {
						handleItem(item0);
					} else {

						j = i + 1;
						break;
					}
				}

				if (i >= size - 1)
					break;

				for (; j < size; j++) {

					Item<T> item1 = items.get(j);

					if (item1.out == 0) {
						handleItem(item1);

						items.set(i, item1);
						items.set(j, item0);

						i++;
						break;
					}
				}
			}

			for (int k = 0; k < size; k++) {

				this.values[k] = this.items.get(k).value;
			}

			return this.values;
		}

		public T[] getValues() {
			return this.values;
		}

	}

	public static <T> T[] sort(T[] values, Dependence<T> dependence) {
		return sortByBreadth(values, dependence);
	}

	public static <T> T[] sortByBreadth(T[] values, Dependence<T> dependence) {

		BreadthSorter<T> sorter = new BreadthSorter<T>(values, dependence);
		return sorter.sort();
	}

	public static <T> T[] sortByComparator(T[] values, Dependence<T> dependence) {

		ComparatorSorter<T> sorter = new ComparatorSorter<T>(values, dependence);
		return sorter.sort();
	}

}
