package net.fastj.lang.result;

import java.util.Map;

public class MapElementResult extends AbstractResult {

	@SuppressWarnings("rawtypes")
	private final Map map;

	private final Object key;

	@SuppressWarnings("rawtypes")
	public MapElementResult(Map map, Object key) {
		this.map = map;
		this.key = key;
	}

	@Override
	public Object get() {
		return this.map.get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(Object value) {
		this.map.put(this.key, value);
	}

}
