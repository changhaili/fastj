package net.fastj.lang;

import java.text.MessageFormat;
import java.util.ArrayList;

import net.fastj.ForardChars;
import net.fastj.LangEnginers;
import net.fastj.Strings;
import net.fastj.lang.invoker.MethodAliases;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.node.AbstractLangNode;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.result.ConstResult;
import net.fastj.lang.result.Result;

public class ExpressionParser {

	public static class TextBuilder {

		StringBuilder builder = new StringBuilder();

		@MethodAliases(aliases = { "()" })
		public synchronized void append(Object text) {
			builder.append(text);
		}

		@Override
		public synchronized String toString() {
			return builder.toString();
		}
	}

	public class StringNode extends AbstractLangNode {

		public final String value;

		public StringNode(String value) {
			super(null);
			this.value = value;
		}

		@Override
		protected Result doEval(MModelContext context) {
			return new ConstResult(this.value);
		}
	}

	private final String sourceBegin;// = "{";

	private final String sourceEnd;// = "}";

	private final String controlSourcePrefix;// = "$";

	private final char escape;// = '\\';

	private final String textPrefix;// = "@";

	public ExpressionParser(String sourceBegin, String sourceEnd, String controlSourcePrefix, char escape,
			String textPrefix) {

		this.sourceBegin = sourceBegin;
		this.sourceEnd = sourceEnd;
		this.controlSourcePrefix = controlSourcePrefix;
		this.escape = escape;
		this.textPrefix = textPrefix;
	}

	public String discriminateSource(ForardChars chars) {

		StringBuilder builder = new StringBuilder();

		int blockCount = 0;

		while (!chars.isEmpty()) {

			char c = chars.top();

			if (c == '\"') {

				builder.append(c);
				chars.skip(1);

				boolean esc = false;
				while (!chars.isEmpty()) {

					char n = chars.top();
					builder.append(n);

					if (esc) {
						esc = false;
					} else {
						if (n == '\\') {
							esc = true;
						} else if (n == '"') {
							chars.skip(1);
							break;
						}
					}

					chars.skip(1);
				}
			}

			else if (c == '\'') {

				builder.append(c);
				chars.skip(1);

				boolean esc = false;
				while (!chars.isEmpty()) {

					char n = chars.top();
					builder.append(n);

					if (esc) {
						esc = false;
					} else {
						if (n == '\\') {
							esc = true;
						} else if (n == '\'') {
							chars.skip(1);
							break;
						}
					}

					chars.skip(1);
				}
			} else if (chars.leftEquals(sourceBegin)) { // c == '{'
				blockCount += 1;
				builder.append(sourceBegin);
				chars.skip(sourceBegin.length());

			} else if (chars.leftEquals(sourceEnd)) { // c == '}'

				if (blockCount == 0) {
					return builder.toString();
				} else {
					blockCount -= 1;
					builder.append(sourceEnd);
					chars.skip(sourceEnd.length());
				}

			} else {
				builder.append(c);
				chars.skip(1);
			}
		}
		return "";
	}

	private static final String STRING_VARIABLE_NAME = "____0";
	private static final String EXTERNAL_OBJECT_NAME = "____1";

	private static final String STRING_OUTPUT_NAME = "output";

	private void appendBrace(StringBuilder code, String brace) {

		if (brace.startsWith(this.controlSourcePrefix)) {

			code.append(brace.substring(this.controlSourcePrefix.length()));
			code.append("\n");

		} else {

			brace.trim();

			while (brace.endsWith(";")) {
				brace = brace.substring(0, brace.length() - 2).trim();
			}

			String line = MessageFormat.format("{0}.append({1});\n", STRING_VARIABLE_NAME, brace);
			code.append(line);
		}

	}

	private void appendText(StringBuilder code, ArrayList<String> texts, String text) {

		int index = texts.size();
		texts.add(text);

		String line = MessageFormat.format("{0}.append({1}.get({2}));\n", STRING_VARIABLE_NAME, EXTERNAL_OBJECT_NAME,
				index);
		code.append(line);
	}

	public LangNode parse(MModelContext datums, final ForardChars chars, String... stops) {

		if (chars.leftEquals(this.textPrefix)) {
			return new StringNode(chars.subSequence(this.textPrefix.length()).toString());
		}

		String oldExpression = chars.toString();

		ArrayList<String> texts = new ArrayList<String>();

		datums.putCustomer(EXTERNAL_OBJECT_NAME, texts);

		StringBuilder code = new StringBuilder();

		boolean textOnly = true;
		code.append("var ").append(STRING_VARIABLE_NAME).append(" = new ").append(TextBuilder.class.getName())
				.append("();\n");

		code.append("var ").append(STRING_OUTPUT_NAME).append(" = ").append(STRING_VARIABLE_NAME).append(";\n");

		StringBuilder builder = new StringBuilder();
		boolean esc = false;
		while (!chars.isEmpty()) {

			char c = chars.top();

			if (esc) {
				if (c == this.escape) {
					builder.append(c);
				} else if (c == '{') {
					builder.append(c);
				} else if (c == 'r') {
					builder.append('\r');
				} else if (c == 'b') {
					builder.append('\b');
				} else if (c == 't') {
					builder.append('\t');
				} else if (c == 'f') {
					builder.append('\f');
				} else if (c == 'n') {
					builder.append('\n');
				} else if (c == '@') {
					builder.append('@');
				} else if (c >= '0' && c <= '9') {
					builder.append(c - '0');
				} else {
					throw new RuntimeException();
				}
				esc = false;

				chars.skip(1);

			} else {
				if (c == this.escape) {
					esc = true;
					chars.skip(1);

				} else if (chars.leftEquals(sourceBegin)) { // c == '{'

					if (builder.length() != 0) {

						this.appendText(code, texts, builder.toString());
						builder.delete(0, builder.length());
					}
					chars.skip(sourceBegin.length());
					String brace = discriminateSource(chars);

					textOnly = false;
					this.appendBrace(code, brace);

					chars.skip(sourceEnd.length());

				} else {

					if (stops.length != 0) {
						if (Strings.indexOfLeftEquals(stops, chars) >= 0) {
							break;
						}
					}

					builder.append(c);
					chars.skip(1);
				}
			}

		}
		if (builder.length() != 0) {
			this.appendText(code, texts, builder.toString());
		}

		code.append(STRING_VARIABLE_NAME).append(".toString();");

		if (textOnly) {
			return new StringNode(oldExpression);
		} else {
			return LangEnginers.parseCode(code.toString(), datums);
		}

	}
}
