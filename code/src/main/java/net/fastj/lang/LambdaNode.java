package net.fastj.lang;

import net.fastj.lang.node.FunctionNode;
import net.fastj.lang.node.LangNode;

public interface LambdaNode extends LangNode {

	Class<?> getDeclaredClass();

	String getFunctionName();

	FunctionNode getFunction();
}
