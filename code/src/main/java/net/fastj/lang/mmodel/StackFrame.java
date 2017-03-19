package net.fastj.lang.mmodel;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;

public class StackFrame {

	private StackFrame parentFrame;

	private StackBlock currentBlock;

	StackFrame(StackFrame parentFrame) {
		this.parentFrame = parentFrame;
		this.currentBlock = new StackBlock();
	}

	StackFrame(GlobalBlock globalBlock) {
		this.currentBlock = globalBlock;
		this.parentFrame = null;
	}

	public StackFrame getParent() {
		return this.parentFrame;
	}

	public StackBlock getCurrentBlock() {
		return this.currentBlock;
	}

	protected StackBlock searchBlock(String name) {

		StackBlock s = this.currentBlock;

		while (s != null) {
			if (s.contains(name)) {
				return s;
			}

			s = s.getParent();
		}

		return null;
	}

	public Set<String> getNames() {

		HashSet<String> stacks = new HashSet<String>();

		StackBlock s = this.currentBlock;

		while (s != null) {
			stacks.addAll(s.getNames());
			s = s.getParent();
		}

		return stacks;

	}

	public Object getValue(String name) {

		StackBlock s = this.searchBlock(name);
		if (s == null)
			return null;

		return s.getValue(name);
	}

	public boolean contains(String name) {
		return this.searchBlock(name) != null;
	}

	public Object putCustomer(String name, Object value) {

		StackBlock s = this.searchBlock(name);
		if (s != null) {
			return s.putCustomer(name, value);
		} else {
			defineCustomer(name, value);
			return null;
		}

	}

	public boolean isCustomer(String name) {

		StackBlock s = this.searchBlock(name);
		if (s == null) {
			return false;
		}

		return s.isCustomer(name);

	}

	public void putFunction(String name, FunctionNode function) {
		this.currentBlock.putFunction(name, function);
	}

	public void putType(String name, KlassNode klass) {
		this.currentBlock.putType(name, klass);
	}

	public void putConstants(String name, Object value) {
		this.currentBlock.putConstants(name, value);
	}

	public void defineCustomer(String name, Object value) {
		this.currentBlock.putCustomer(name, value);
	}

	public boolean isType(String name) {

		StackBlock s = this.searchBlock(name);
		if (s == null)
			return false;

		return s.isType(name);
	}

	public Class<?> forClass(String name) {

		StackBlock s = this.currentBlock;

		while (s != null) {
			Class<?> cls = s.forClass(name);

			if (cls != null)
				return cls;

			s = s.getParent();
		}
		return null;
	}

	public void imports(String... names) {
		this.currentBlock.imports(names);
	}

	@Override
	public String toString() {

		Set<String> names = this.getNames();

		return StringUtils.join(names, " , ");

	}

	public void enterNewBlock() {

		StackBlock block = new StackBlock();
		block.parent = this.currentBlock;
		this.currentBlock = block;

	}

	public void leaveBlock() {

		if (this.currentBlock.parent != null)
			this.currentBlock = this.currentBlock.parent;
	}
}
