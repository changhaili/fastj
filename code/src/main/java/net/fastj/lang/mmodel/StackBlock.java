package net.fastj.lang.mmodel;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import net.fastj.Null;
import net.fastj.Strings;
import net.fastj.collection.CombinedSet;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;
import net.fastj.lang.reflection.Reflections;

public class StackBlock {

	protected StackBlock parent;

	// declare variables
	protected final Map<String, Object> customers = new ConcurrentHashMap<String, Object>();

	// declare functions
	protected final Map<String, FunctionNode> functions = new ConcurrentHashMap<String, FunctionNode>();

	// declare classes
	protected final Map<String, KlassNode> klasses = new ConcurrentHashMap<String, KlassNode>();

	// runtime constants, such as __FILE__
	protected final Map<String, Object> constants = new ConcurrentHashMap<String, Object>();

	// import packages, like import java.lang.*
	protected final Set<String> importPackages = new ConcurrentSkipListSet<String>();

	// imports classes, like import java.lang.String
	protected final Map<String, String> importClasses = new ConcurrentHashMap<String, String>();

	public StackBlock getParent() {
		return this.parent;
	}

	public Object getValue(String name) {

		Object v = null;

		if (this.customers.containsKey(name)) {
			v = this.customers.get(name);
		} else if (this.functions.containsKey(name)) {
			v = this.functions.get(name);
		} else if (this.klasses.containsKey(name)) {
			v = this.klasses.get(name);
		} else if (this.constants.containsKey(name)) {
			v = this.constants.get(name);
		}

		if (v == Null.Instance) {
			return null;
		}

		return v;
	}

	public Set<String> getNames() {

		return new CombinedSet<String>(this.customers.keySet(), this.functions.keySet(), this.klasses.keySet(),
				this.constants.keySet());

	}

	public boolean contains(String name) {

		return this.constants.containsKey(name) || this.customers.containsKey(name) || this.functions.containsKey(name)
				|| this.klasses.containsKey(name);
	}

	public Object putCustomer(String name, Object value) {
		return this.customers.put(name, value == null ? Null.Instance : value);
	}

	public boolean isCustomer(String name) {
		return this.customers.containsKey(name);
	}

	public void putFunction(String name, FunctionNode function) {
		this.functions.put(name, function);
	}

	public void putType(String name, KlassNode klass) {
		this.klasses.put(name, klass);
	}

	public void putConstants(String name, Object value) {
		this.constants.put(name, value == null ? Null.Instance : value);
	}

	public boolean isType(String name) {
		return this.klasses.containsKey(name);
	}

	public Class<?> forClass(String name) {

		try {
			Reflections.classForName(name, null);
		} catch (Exception ex) {
		}

		if (this.importClasses.containsKey(name)) {

			try {
				return Class.forName(this.importClasses.get(name));
			} catch (ClassNotFoundException e) {

			}
		}

		return Reflections.classForName(name, null,
				this.importPackages.toArray(new String[this.importPackages.size()]));
	}

	public void imports(String... names) {

		for (String name : names) {

			if (name.endsWith(".*")) {
				this.importPackages.add(name.substring(0, name.length() - 2));

			} else {

				this.importClasses.put(Strings.rightPart(name, "."), name);
			}
		}

	}

}
