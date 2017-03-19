package net.fastj.lang.node.segment;

import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.SourceInfo;

public abstract class AbstractSegment extends AbstractLangNode {

	protected AbstractSegment(SourceInfo source) {
		super(source);
	}

	@Override
	protected boolean hasBlock() {
		return true;
	}
}
