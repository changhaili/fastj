package net.fastj;

public interface Filter<T> {

	boolean isSatisfied(T obj);
}
