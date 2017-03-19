package net.fastj.lang.mmodel;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.fastj.collection.CombinedSet;
import net.fastj.lang.invoker.InvokeUtils;

public class GlobalBlock extends StackBlock {

	private final Prober prober;

	private final Printer printer;

	private final Map<String, Object> javaMethods = new HashMap<String, Object>();

	public Prober getProber() {
		return this.prober;
	}

	public Printer getPrinter() {
		return this.printer;
	}

	public GlobalBlock(Prober prober, Printer printer) {

		this.printer = printer;
		this.prober = prober;

		this.imports("java.lang.*", "java.util.*");

		InvokeUtils.appendMethods(this);
	}

	@Override
	public Set<String> getNames() {

		if (this.prober == null) {
			return new CombinedSet<String>(super.getNames(), this.javaMethods.keySet());
		}

		final String[] proberNames = prober.getNames();

		Set<String> names = new AbstractSet<String>() {

			@Override
			public int size() {
				return proberNames.length;
			}

			@Override
			public Iterator<String> iterator() {
				return Arrays.asList(proberNames).iterator();
			}
		};

		return new CombinedSet<String>(super.getNames(), this.javaMethods.keySet(), names);
	}

	public void addMethod(String name, Object method) {
		this.javaMethods.put(name, method);
	}

	@Override
	public boolean contains(String name) {

		if (super.contains(name)) {
			return true;
		}

		if (this.javaMethods.containsKey(name)) {
			return true;
		}

		if (this.prober == null) {
			return false;
		}

		return this.prober.contains(name);
	}

	@Override
	public Object getValue(String name) {
		if (super.contains(name)) {
			return super.getValue(name);
		}

		if (this.javaMethods.containsKey(name)) {
			return this.javaMethods.get(name);
		}

		if (this.prober == null) {
			return null;
		}

		return this.prober.get(name);
	}

}
