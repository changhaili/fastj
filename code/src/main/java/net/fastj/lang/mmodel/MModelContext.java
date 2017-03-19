package net.fastj.lang.mmodel;

import java.util.Set;

import org.apache.commons.lang.StringUtils;

import net.fastj.collection.CombinedSet;
import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.KlassNode;

public class MModelContext {

	private final GlobalBlock globalBlock;

	private final StackFrame globalFrame;

	private final StackFrame currentFrame;

	public MModelContext(GlobalBlock globalBlock, StackFrame globalFrame, StackFrame currentFrame) {
		super();
		this.globalBlock = globalBlock;
		this.globalFrame = globalFrame;
		this.currentFrame = currentFrame;
	}

	public MModelContext(Prober prober, Printer printer) {

		this.globalBlock = new GlobalBlock(prober, printer);
		this.globalFrame = new StackFrame(globalBlock);
		this.currentFrame = this.globalFrame;
	}

	public GlobalBlock getGlobal() {
		return this.globalBlock;
	}

	public Set<String> getNames() {

		if (this.currentFrame == this.globalFrame) {
			return this.currentFrame.getNames();
		}

		return new CombinedSet<String>(this.currentFrame.getNames(), this.globalFrame.getNames());
	}

	private StackBlock searchBlock(String name) {

		if (name.startsWith(".")) {

			if (this.globalFrame.contains(name.substring(1)))
				return this.globalFrame.getCurrentBlock();
		}

		StackBlock block = this.currentFrame.searchBlock(name);
		if (block != null) {
			return block;
		}

		if (this.globalFrame.contains(name)) {
			return this.globalFrame.getCurrentBlock();
		}

		return null;
	}

	private String formatName(String name) {
		return name.charAt(0) == '.' ? name.substring(1) : name;
	}

	public void defineCustomer(String name, Object value) {

		if (name.startsWith(".")) {
			this.currentFrame.putCustomer(this.formatName(name), value);
		}

		this.currentFrame.defineCustomer(name, value);
	}

	public Object getValue(String name) {
		StackBlock block = this.searchBlock(name);

		if (block == null)
			return null;

		return block.getValue(this.formatName(name));
	}

	public boolean contains(String name) {
		return this.searchBlock(name) != null;
	}

	public Object putCustomer(String name, Object value) {

		StackBlock block = this.searchBlock(name);

		if (block == null) {
			this.defineCustomer(this.formatName(name), value);

			return null;
		}

		return block.putCustomer(this.formatName(name), value);

	}

	public boolean isCustomer(String name) {

		StackBlock block = this.searchBlock(name);

		if (block == null) {
			return false;
		}

		return block.isCustomer(this.formatName(name));

	}

	public void putFunction(String name, FunctionNode function) {
		this.currentFrame.putFunction(name, function);
	}

	public void putType(String name, KlassNode klass) {
		this.currentFrame.putType(name, klass);
	}

	public void putConstants(String name, Object value) {
		this.currentFrame.putConstants(name, value);
	}

	public boolean isType(String name) {

		StackBlock block = this.searchBlock(name);

		if (block == null) {
			return false;
		}

		return block.isType(name);
	}

	public Class<?> forClass(String name) {

		Class<?> cls = this.currentFrame.forClass(name);
		if (cls != null) {
			return cls;
		}

		if (this.currentFrame == this.globalFrame) {
			return null;
		}

		return this.globalFrame.forClass(name);
	}

	public void imports(String... names) {
		this.currentFrame.imports(names);
	}

	public MModelContext newFrame() {

		StackFrame newFrame = new StackFrame(this.currentFrame);

		MModelContext datums = new MModelContext(this.globalBlock, this.globalFrame, newFrame);

		return datums;
	}

	public void enterBlock() {
		this.currentFrame.enterNewBlock();
	}

	public void leaveBlock() {
		this.currentFrame.leaveBlock();

	}

	@Override
	public String toString() {

		Set<String> names = this.getNames();

		return StringUtils.join(names, " , ");

	}

}
