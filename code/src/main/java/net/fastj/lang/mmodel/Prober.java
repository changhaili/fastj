package net.fastj.lang.mmodel;

public interface Prober {

	Object get(String name);

	boolean contains(String name);

	String[] getNames();
}
