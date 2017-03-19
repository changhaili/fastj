package net.fastj.lang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.fastj.ForardChars;
import net.fastj.collection.ArrayKey;
import net.fastj.lang.ExpressionParser.StringNode;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.result.IDResult;
import net.fastj.lang.result.Result;

public class Expression {

	private final String expression;

	public Expression(String expression) {

		this.expression = expression;
	}

	private static final Map<ArrayKey, LangNode> map = new ConcurrentHashMap<ArrayKey, LangNode>();

	private LangNode parse(ExpressionParser parser, MModelContext datums) {

		ArrayKey key = new ArrayKey(this.expression.intern(), datums);

		LangNode node = map.getOrDefault(key, null);
		if (node != null)
			return null;

		node = parser.parse(datums, new ForardChars(this.expression));

		map.put(key, node);

		return node;

	}

	public Object current(ExpressionParser parser, MModelContext context) {

		LangNode node = this.parse(parser, context);

		if (node instanceof StringNode) {
			return ((StringNode) node).value;
		}

		Result v = LangUtils.eval(node, context.newFrame());
		if (v instanceof IDResult) {
			return "";
		}
		return v.get();
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Expression))
			return false;

		String other = ((Expression) obj).expression;
		if (other == this.expression)
			return true;

		return this.expression != null && this.expression.equals(other);
	}

}
