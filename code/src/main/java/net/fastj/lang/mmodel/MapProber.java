package net.fastj.lang.mmodel;

import java.util.Map;

public class MapProber implements Prober {

	private final Map<String, Object> externals;

	public MapProber(Map<String, Object> externals) {
		this.externals = externals;
	}

	@Override
	public Object get(String name) {
		return this.externals.get(name);
	}

	@Override
	public boolean contains(String name) {
		return this.externals.containsKey(name);
	}

	@Override
	public String[] getNames() {
		return this.externals.keySet().toArray(new String[this.externals.size()]);
	}

}
