package net.fastj;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Log4jConfigurer;

import net.fastj.antlrgenerator.LangLexer;
import net.fastj.antlrgenerator.LangParser;
import net.fastj.antlrgenerator.LangParser.SourceContext;
import net.fastj.antlrgenerator.LangParser.TermContext;
import net.fastj.lang.LangException;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.MModelContext;
import net.fastj.lang.mmodel.MapProber;
import net.fastj.lang.mmodel.Printer;
import net.fastj.lang.node.LangNode;
import net.fastj.lang.node.NodeVisitor;
import net.fastj.lang.result.Result;
import net.fastj.lang.result.TokenResult;

public class LangEnginers {

	public static LangNode parseSimpleExpr(String str, MModelContext datums) {

		ANTLRInputStream input = new ANTLRInputStream(str);
		LangLexer lexer = new LangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LangParser parser = new LangParser(tokens);
		try {
			TermContext ctxt = parser.term();

			NodeVisitor visitor = new NodeVisitor(datums.getGlobal().getProber(),
					datums.getGlobal().getPrinter());

			return LangUtils.wrap(visitor.visit(ctxt)).optimize(datums);

		} catch (Exception e) {
			throw new LangException(str, e);
		}
	}

	public static LangNode parseCode(String str, MModelContext datums) {

		str = str.trim();
		if (!str.endsWith(";") && !str.endsWith("}")) {
			str = str + " ;";
		}

		ANTLRInputStream input = new ANTLRInputStream(str);
		LangLexer lexer = new LangLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LangParser parser = new LangParser(tokens);

		try {
			SourceContext ctxt = parser.source();

			NodeVisitor visitor = new NodeVisitor(datums.getGlobal().getProber(),
					datums.getGlobal().getPrinter());

			Object v = visitor.visit(ctxt);
			if (v instanceof Result) {
				v = ((Result) v).get();
			}

			return LangUtils.wrap(v).optimize(datums);

		} catch (Exception e) {
			throw new LangException(str, e);
		}

	}

	public static void main(String[] args) throws ParseException, IOException {

		Log4jConfigurer.shutdownLogging();

		CommandParser parser = new CommandParser();
		parser.setShowUsageIfEmpty(true);

		parser.add("f", "file", true, "source file");
		parser.add("e", "expr", true, "expression");

		Map<String, Object> results = new LinkedHashMap<String, Object>();
		Map<String, Object> externals = new LinkedHashMap<String, Object>();

		if (!parser.apply(args, results, externals)) {
			return;
		}
		String code = null;
		String file = null;

		if (results.containsKey("e")) {
			code = (String) results.get("e");

		} else if (results.containsKey("f")) {

			file = (String) results.get("f");

			code = FileUtils.readFileToString(new File(file), "utf-8");
		}

		if (StringUtils.isBlank(code)) {
			return;
		}

		MModelContext context = new MModelContext(new MapProber(externals), Printer.Console);

		if (file != null) {
			context.putConstants("__FILE__", file);
		}

		LangNode node = parseCode(code, context);

		node = LangUtils.optimize(node, context);

		Result v = LangUtils.eval(node, context);

		if (!(v instanceof TokenResult)) {

			Object obj = v.get();
			if (obj != null) {
				System.out.println(v.get());
			}
		}
	}

}
