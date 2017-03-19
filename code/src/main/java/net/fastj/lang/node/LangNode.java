package net.fastj.lang.node;

import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.result.Result;

/**
 * Root Node
 * 
 * @author lichanghai
 *
 */
public interface LangNode {

	LangNode getParent();

	void setParent(LangNode parent);

	SourceInfo getSource();

	LangNode optimize(MModelContext context);

	Result eval(MModelContext context);

}
