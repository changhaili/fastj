package net.fastj.lang.node;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import net.fastj.antlrgenerator.LangBaseVisitor;
import net.fastj.antlrgenerator.LangParser;
import net.fastj.antlrgenerator.LangParser.AssignStatmentContext;
import net.fastj.antlrgenerator.LangParser.AssignTermContext;
import net.fastj.antlrgenerator.LangParser.AtomicObjectContext;
import net.fastj.antlrgenerator.LangParser.BasicTermContext;
import net.fastj.antlrgenerator.LangParser.BinaryTermContext;
import net.fastj.antlrgenerator.LangParser.BlockSegmentContext;
import net.fastj.antlrgenerator.LangParser.BreakStatementContext;
import net.fastj.antlrgenerator.LangParser.CastTermContext;
import net.fastj.antlrgenerator.LangParser.ConditionTermContext;
import net.fastj.antlrgenerator.LangParser.ConstTermContext;
import net.fastj.antlrgenerator.LangParser.ContinueStatementContext;
import net.fastj.antlrgenerator.LangParser.DefaultTermContext;
import net.fastj.antlrgenerator.LangParser.DefinedTermContext;
import net.fastj.antlrgenerator.LangParser.DotClassTermContext;
import net.fastj.antlrgenerator.LangParser.DotTermContext;
import net.fastj.antlrgenerator.LangParser.DowhileSegmemtContext;
import net.fastj.antlrgenerator.LangParser.ForSegmentContext;
import net.fastj.antlrgenerator.LangParser.ForeachSegmentContext;
import net.fastj.antlrgenerator.LangParser.FunctionContext;
import net.fastj.antlrgenerator.LangParser.GlobalIDTermContext;
import net.fastj.antlrgenerator.LangParser.IfElseSegmentContext;
import net.fastj.antlrgenerator.LangParser.InTermContext;
import net.fastj.antlrgenerator.LangParser.IndicesTermContext;
import net.fastj.antlrgenerator.LangParser.InvokeTermContext;
import net.fastj.antlrgenerator.LangParser.IsTermContext;
import net.fastj.antlrgenerator.LangParser.JlambdaTermContext;
import net.fastj.antlrgenerator.LangParser.KeywordTermContext;
import net.fastj.antlrgenerator.LangParser.KlassContext;
import net.fastj.antlrgenerator.LangParser.KlassNameContext;
import net.fastj.antlrgenerator.LangParser.LambdaTermContext;
import net.fastj.antlrgenerator.LangParser.ListTermContext;
import net.fastj.antlrgenerator.LangParser.LockSegmentContext;
import net.fastj.antlrgenerator.LangParser.MapTermContext;
import net.fastj.antlrgenerator.LangParser.NewTermContext;
import net.fastj.antlrgenerator.LangParser.OperatorFunctionContext;
import net.fastj.antlrgenerator.LangParser.ParenthesisTermContext;
import net.fastj.antlrgenerator.LangParser.PostSelfUnaryTermContext;
import net.fastj.antlrgenerator.LangParser.PreSelfUnaryTermContext;
import net.fastj.antlrgenerator.LangParser.PrimitiveTermContext;
import net.fastj.antlrgenerator.LangParser.ReturnStatementContext;
import net.fastj.antlrgenerator.LangParser.SegmentContext;
import net.fastj.antlrgenerator.LangParser.SourceContext;
import net.fastj.antlrgenerator.LangParser.StatementSegmentContext;
import net.fastj.antlrgenerator.LangParser.SwitchSegmentContext;
import net.fastj.antlrgenerator.LangParser.TermContext;
import net.fastj.antlrgenerator.LangParser.TermStatementContext;
import net.fastj.antlrgenerator.LangParser.ThrowStatementContext;
import net.fastj.antlrgenerator.LangParser.TrySegmentContext;
import net.fastj.antlrgenerator.LangParser.UnaryTermContext;
import net.fastj.antlrgenerator.LangParser.WhileSegmentContext;
import net.fastj.antlrgenerator.LangParser.YieldStatementContext;
import net.fastj.lang.LangUtils;
import net.fastj.lang.mmodel.GlobalBlock;
import net.fastj.lang.mmodel.Printer;
import net.fastj.lang.mmodel.Prober;
import net.fastj.lang.node.segment.BlockSegment;
import net.fastj.lang.node.segment.DoWhileSegment;
import net.fastj.lang.node.segment.ForSegment;
import net.fastj.lang.node.segment.ForeachSegment;
import net.fastj.lang.node.segment.IfElseSegment;
import net.fastj.lang.node.segment.LockSegment;
import net.fastj.lang.node.segment.StatementSegment;
import net.fastj.lang.node.segment.SwitchSegment;
import net.fastj.lang.node.segment.TrySegment;
import net.fastj.lang.node.segment.WhileSegment;
import net.fastj.lang.node.statement.AssignStatement;
import net.fastj.lang.node.statement.BreakStatement;
import net.fastj.lang.node.statement.ContinueStatement;
import net.fastj.lang.node.statement.ExpressionStatement;
import net.fastj.lang.node.statement.ReturnStatement;
import net.fastj.lang.node.statement.ThrowStatement;
import net.fastj.lang.node.statement.YieldStatement;
import net.fastj.lang.node.term.AsTerm;
import net.fastj.lang.node.term.AssignTerm;
import net.fastj.lang.node.term.BinaryTerm;
import net.fastj.lang.node.term.ConditionTerm;
import net.fastj.lang.node.term.DefaultTerm;
import net.fastj.lang.node.term.DefinedTerm;
import net.fastj.lang.node.term.DotTerm;
import net.fastj.lang.node.term.IDTerm;
import net.fastj.lang.node.term.InTerm;
import net.fastj.lang.node.term.InvokeTerm;
import net.fastj.lang.node.term.IsTerm;
import net.fastj.lang.node.term.JavaLambdaTerm;
import net.fastj.lang.node.term.LambdaTerm;
import net.fastj.lang.node.term.ListTerm;
import net.fastj.lang.node.term.MapTerm;
import net.fastj.lang.node.term.NewTerm;
import net.fastj.lang.node.term.ParenthesisTerm;
import net.fastj.lang.node.term.SelfPlusMinusTerm;
import net.fastj.lang.node.term.UnaryTerm;

public class NodeVisitor extends LangBaseVisitor<Object> {

	final GlobalBlock globalBlock;

	public NodeVisitor(Prober prober, Printer printer) {
		this.globalBlock = new GlobalBlock(prober, printer);
	}

	private LangNode[] getChildrenExprs(TermContext exprContext, int beginIndex) {

		List<ParseTree> children = exprContext.children;

		List<LangNode> nodes = new ArrayList<LangNode>();

		int count = 0;
		for (int i = 0, size = children.size(); i < size; i++) {
			ParseTree child = children.get(i);

			if (child instanceof TermContext) {

				count++;
				if (count > beginIndex) {

					LangNode node = LangUtils.wrap(this.visit(child));
					nodes.add(node);
				}
			}
		}

		return nodes.toArray(new LangNode[nodes.size()]);
	}

	@Override
	public Object visitParenthesisTerm(ParenthesisTermContext ctx) {

		LangNode[] nodes = this.getChildrenExprs(ctx, 0);

		return new ParenthesisTerm(new SourceInfo(this, ctx), nodes);
	}

	@Override
	public Object visitListTerm(ListTermContext ctx) {

		List<TermContext> list = ctx.term();

		LangNode[] nodes = new LangNode[list.size()];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = LangUtils.wrap(this.visit(list.get(i)));
		}

		return new ListTerm(new SourceInfo(this, ctx), nodes);
	}

	@Override
	public Object visitMapTerm(MapTermContext ctx) {
		return new MapTerm(new SourceInfo(this, ctx), this.getChildrenExprs(ctx, 0));
	}

	@Override
	public Object visitUnaryTerm(UnaryTermContext ctx) {
		return new UnaryTerm(new SourceInfo(this, ctx), LangUtils.wrap(this.visit(ctx.term())), ctx.op);
	}

	@Override
	public Object visitBinaryTerm(BinaryTermContext ctx) {
		return new BinaryTerm(new SourceInfo(this, ctx), LangUtils.wrap(this.visit(ctx.term(0))),
				LangUtils.wrap(this.visit(ctx.term(1))), ctx.op);
	}

	@Override
	public Object visitConditionTerm(ConditionTermContext ctx) {

		ParseTree expr0 = ctx.getChild(0);
		ParseTree expr1 = ctx.getChild(2);
		ParseTree expr2 = ctx.getChild(4);

		LangNode arg0 = LangUtils.wrap(this.visit(expr0));
		LangNode arg1 = LangUtils.wrap(this.visit(expr1));
		LangNode arg2 = LangUtils.wrap(this.visit(expr2));

		return new ConditionTerm(new SourceInfo(this, ctx), arg0, arg1, arg2);
	}

	@Override
	public Object visitDotTerm(DotTermContext ctx) {

		LangNode obj = LangUtils.wrap(this.visit(ctx.term()));
		String child = ctx.ID().getText();

		DotTerm expression = DotTerm.accept(new SourceInfo(this, ctx), obj, child);
		return expression;
	}

	@Override
	public Object visitGlobalIDTerm(GlobalIDTermContext ctx) {
		return new IDTerm(new SourceInfo(this, ctx), "." + ctx.ID().getText());
	}

	@Override
	public Object visitDotClassTerm(DotClassTermContext ctx) {

		LangNode obj = LangUtils.wrap(this.visit(ctx.term()));
		return DotTerm.accept(new SourceInfo(this, ctx), obj, "class");
	}

	@Override
	public Object visitIndicesTerm(IndicesTermContext ctx) {

		LangNode parent = LangUtils.wrap(this.visit(ctx.term(0)));
		return new InvokeTerm(new SourceInfo(this, ctx), parent, this.getChildrenExprs(ctx, 1), true);
	}

	@Override
	public Object visitInvokeTerm(InvokeTermContext ctx) {

		LangNode parent = LangUtils.wrap(this.visit(ctx.term(0)));
		return new InvokeTerm(new SourceInfo(this, ctx), parent, this.getChildrenExprs(ctx, 1), false);
	}

	@Override
	public Object visitNewTerm(NewTermContext ctx) {

		String className = ctx.klassName().getText();

		return new NewTerm(new SourceInfo(this, ctx), className, this.getChildrenExprs(ctx, 0));
	}

	@Override
	public Object visitAtomicObject(AtomicObjectContext ctx) {

		TerminalNodeImpl node = (TerminalNodeImpl) ctx.getChild(0);

		switch (node.symbol.getType()) {
		case LangParser.DATA_NUMBER: {
			String text = ctx.getText();
			if (text.indexOf('e') != -1 || text.indexOf('.') != -1) {

				if (text.endsWith("f")) {
					return Float.parseFloat(text);
				} else {
					return Double.parseDouble(text);
				}
			} else {
				return Integer.parseInt(text);
			}
		}
		case LangParser.DATA_LONG: {
			String text = ctx.getText();
			return Long.parseLong(text.substring(0, text.length() - 1));
		}
		case LangParser.DATA_STRING: {
			String text = ctx.getText();

			if (text.charAt(0) == '@')
				return text.substring(2, text.length() - 1);
			else
				return text.substring(1, text.length() - 1);
		}
		case LangParser.DATA_CHAR: {
			String text = ctx.getText();
			return text.charAt(text.length() - 2);
		}
		case LangParser.ID: {
			String text = ctx.getText();
			return new IDTerm(new SourceInfo(this, ctx), text);
		}
		default: {
			return ctx.getText();
		}
		}
	}

	@Override
	public Object visitConstTerm(ConstTermContext ctx) {

		String text = ctx.getText().trim();

		if ("true".equals(text)) {
			return true;
		} else if ("false".equals(text)) {
			return false;
		} else if ("null".equals(text)) {
			return null;
		}

		return new IDTerm(new SourceInfo(this, ctx), text);
	}

	@Override
	public Object visitKeywordTerm(KeywordTermContext ctx) {

		String text = ctx.getText().trim();
		return new IDTerm(new SourceInfo(this, ctx), text);
	}

	@Override
	public Object visitPrimitiveTerm(PrimitiveTermContext ctx) {
		String text = ctx.getText();
		return new IDTerm(new SourceInfo(this, ctx), text);
	}

	@Override
	public Object visitBasicTerm(BasicTermContext ctx) {
		return this.visit(ctx.atomicObject());
	}

	@Override
	public Object visitIsTerm(IsTermContext ctx) {

		LangNode obj = LangUtils.wrap(this.visit(ctx.term(0)));
		LangNode cls = LangUtils.wrap(this.visit(ctx.term(1)));

		return new IsTerm(new SourceInfo(this, ctx), obj, cls);

	}

	@Override
	public Object visitCastTerm(CastTermContext ctx) {
		LangNode obj = LangUtils.wrap(this.visit(ctx.term(0)));
		LangNode cls = LangUtils.wrap(this.visit(ctx.term(1)));

		return new AsTerm(new SourceInfo(this, ctx), obj, cls);
	}

	@Override
	public Object visitInTerm(InTermContext ctx) {
		LangNode obj = LangUtils.wrap(this.visit(ctx.term(0)));
		LangNode col = LangUtils.wrap(this.visit(ctx.term(1)));

		return new InTerm(new SourceInfo(this, ctx), obj, col);
	}

	@Override
	public Object visitDefaultTerm(DefaultTermContext ctx) {

		LangNode cls = LangUtils.wrap(this.visit(ctx.term()));
		return new DefaultTerm(new SourceInfo(this, ctx), cls);
	}

	@Override
	public Object visitDefinedTerm(DefinedTermContext ctx) {
		return new DefinedTerm(new SourceInfo(this, ctx), ctx.fullPath().getText());
	}

	@Override
	public Object visitAssignTerm(AssignTermContext ctx) {

		LangNode leftExpr = LangUtils.wrap(this.visit(ctx.term(0)));
		LangNode rightExpr = LangUtils.wrap(this.visit(ctx.term(1)));

		return new AssignTerm(new SourceInfo(this, ctx), leftExpr, rightExpr, ctx.op.getText());

	}

	@Override
	public Object visitPreSelfUnaryTerm(PreSelfUnaryTermContext ctx) {

		LangNode expr = LangUtils.wrap(this.visit(ctx.term()));

		return new SelfPlusMinusTerm(new SourceInfo(this, ctx), expr, ctx.op, true);
	}

	@Override
	public Object visitPostSelfUnaryTerm(PostSelfUnaryTermContext ctx) {
		LangNode expr = LangUtils.wrap(this.visit(ctx.term()));
		return new SelfPlusMinusTerm(new SourceInfo(this, ctx), expr, ctx.op, false);
	}

	@Override
	public Object visitAssignStatment(AssignStatmentContext ctx) {
		String name = ctx.variantName().getText();

		LangNode expr = ctx.term() == null ? null : LangUtils.wrap(this.visit(ctx.term()));

		return new AssignStatement(new SourceInfo(this, ctx), name, expr);
	}

	@Override
	public Object visitTermStatement(TermStatementContext ctx) {

		LangNode expr = LangUtils.wrap(this.visit(ctx.term()));
		return new ExpressionStatement(new SourceInfo(this, ctx), expr);
	}

	@Override
	public Object visitReturnStatement(ReturnStatementContext ctx) {

		LangNode expr = ctx.term() == null ? null : LangUtils.wrap(this.visit(ctx.term()));
		return new ReturnStatement(new SourceInfo(this, ctx), expr);
	}

	@Override
	public Object visitYieldStatement(YieldStatementContext ctx) {
		LangNode expr = ctx.term() == null ? null : LangUtils.wrap(this.visit(ctx.term()));
		return new YieldStatement(new SourceInfo(this, ctx), expr);
	}

	@Override
	public Object visitBlockSegment(BlockSegmentContext ctx) {

		List<SegmentContext> scs = ctx.segment();

		LangNode[] segments = new LangNode[scs.size()];

		for (int i = 0; i < segments.length; i++) {
			segments[i] = LangUtils.wrap(this.visit(scs.get(i)));
		}

		return new BlockSegment(new SourceInfo(this, ctx), segments);

	}

	@Override
	public Object visitStatementSegment(StatementSegmentContext ctx) {

		LangNode segment = LangUtils.wrap(this.visit(ctx.statement()));
		return new StatementSegment(new SourceInfo(this, ctx), segment);
	}

	@Override
	public Object visitForSegment(ForSegmentContext ctx) {

		String label = ctx.label == null ? null : ctx.label.getText();
		LangNode expr0 = LangUtils.wrap(this.visit(ctx.expr0));
		LangNode expr1 = LangUtils.wrap(this.visit(ctx.expr1));
		LangNode expr2 = LangUtils.wrap(this.visit(ctx.expr2));

		LangNode segment = LangUtils.wrap(this.visit(ctx.segment()));
		return new ForSegment(new SourceInfo(this, ctx), label, expr0, expr1, expr2, segment);
	}

	@Override
	public Object visitForeachSegment(ForeachSegmentContext ctx) {

		String label = ctx.label == null ? null : ctx.label.getText();
		String name = ctx.name.getText();

		LangNode collection = LangUtils.wrap(this.visit(ctx.term()));

		LangNode segment = LangUtils.wrap(this.visit(ctx.segment()));
		return new ForeachSegment(new SourceInfo(this, ctx), label, name, collection, segment);

	}

	@Override
	public Object visitIfElseSegment(IfElseSegmentContext ctx) {

		LangNode condition = LangUtils.wrap(this.visit(ctx.term()));
		LangNode ifSegment = LangUtils.wrap(this.visit(ctx.segment(0)));
		LangNode elseSegment = ctx.segment().size() > 1 ? LangUtils.wrap(this.visit(ctx.segment(1))) : null;

		return new IfElseSegment(new SourceInfo(this, ctx), condition, ifSegment, elseSegment);
	}

	@Override
	public Object visitWhileSegment(WhileSegmentContext ctx) {

		String label = ctx.label == null ? null : ctx.label.getText();

		LangNode condition = LangUtils.wrap(this.visit(ctx.term()));
		LangNode segment = LangUtils.wrap(this.visit(ctx.segment()));

		return new WhileSegment(new SourceInfo(this, ctx), label, condition, segment);
	}

	@Override
	public Object visitDowhileSegmemt(DowhileSegmemtContext ctx) {

		String label = ctx.label == null ? null : ctx.label.getText();

		LangNode condition = LangUtils.wrap(this.visit(ctx.term()));
		LangNode segment = LangUtils.wrap(this.visit(ctx.segment()));

		return new DoWhileSegment(new SourceInfo(this, ctx), label, condition, segment);
	}

	@Override
	public Object visitSwitchSegment(SwitchSegmentContext ctx) {

		LangNode inNode = LangUtils.wrap(this.visit(ctx.in));

		List<LangNode> tables = new ArrayList<LangNode>();

		LangNode defaultSegment = ctx.def == null ? null : LangUtils.wrap(this.visit(ctx.def));

		List<LangNode> segments = new ArrayList<LangNode>();

		for (TermContext expression : ctx.term()) {

			if (expression != ctx.in) {
				tables.add(LangUtils.wrap(this.visit(expression)));
			}

		}

		for (SegmentContext segment : ctx.segment()) {

			if (segment != ctx.def) {
				segments.add(LangUtils.wrap(this.visit(segment)));
			}

		}
		return new SwitchSegment(new SourceInfo(this, ctx), inNode, tables.toArray(new LangNode[tables.size()]),
				defaultSegment, segments.toArray(new LangNode[segments.size()]));
	}

	@Override
	public Object visitBreakStatement(BreakStatementContext ctx) {

		String label = ctx.label == null ? null : ctx.label.getText();
		return new BreakStatement(new SourceInfo(this, ctx), label);
	}

	@Override
	public Object visitContinueStatement(ContinueStatementContext ctx) {
		return new ContinueStatement(new SourceInfo(this, ctx));
	}

	@Override
	public Object visitThrowStatement(ThrowStatementContext ctx) {

		LangNode node = LangUtils.wrap(this.visit(ctx.term()));
		return new ThrowStatement(new SourceInfo(this, ctx), node);
	}

	@Override
	public Object visitTrySegment(TrySegmentContext ctx) {

		List<LangNode> trySegments = new ArrayList<LangNode>();
		List<LangNode> catchSegments = new ArrayList<LangNode>();
		List<LangNode> finallySegments = new ArrayList<LangNode>();

		List<LangNode> segments = trySegments;

		String id = ctx.ID().getText();

		for (ParseTree node : ctx.children) {

			if ("catch".equals(node.getText())) {
				segments = catchSegments;
			} else if ("finally".equals(node.getText())) {
				segments = finallySegments;
			}

			if (node instanceof SegmentContext) {
				LangNode segment = LangUtils.wrap(this.visit(node));
				segments.add(segment);
			}
		}

		return new TrySegment(new SourceInfo(this, ctx), trySegments.toArray(new LangNode[trySegments.size()]), id,
				catchSegments.toArray(new LangNode[catchSegments.size()]),
				finallySegments.toArray(new LangNode[finallySegments.size()]));
	}

	@Override
	public Object visitLockSegment(LockSegmentContext ctx) {

		LangNode expression = LangUtils.wrap(this.visit(ctx.term()));
		LangNode segment = LangUtils.wrap(this.visit(ctx.segment()));

		return new LockSegment(new SourceInfo(this, ctx), expression, segment);
	}

	private FunctionNode visitFunction(ParserRuleContext ctx, Object nameToken) {

		List<String> args = new ArrayList<String>();
		List<LangNode> defaults = new ArrayList<LangNode>();
		List<LangNode> segments = new ArrayList<LangNode>();

		String name = (nameToken instanceof Token) ? ((Token) nameToken).getText()
				: ((ParserRuleContext) nameToken).getText();

		for (int i = 0, size = ctx.getChildCount(); i < size; i++) {

			ParseTree child = ctx.getChild(i);

			if ((nameToken instanceof Token) && (child instanceof TerminalNode)
					&& ((TerminalNode) child).getSymbol() == nameToken) {
				continue;
			}

			if ((nameToken instanceof ParserRuleContext) && child == nameToken) {
				continue;
			}

			if (child instanceof TerminalNode) {

				if (((TerminalNode) child).getSymbol().getType() != LangParser.ID)
					continue;

				args.add(child.getText());
			}

			if (child instanceof AtomicObjectContext) {
				defaults.add(LangUtils.wrap(this.visit(child)));
			}

			if (child instanceof SegmentContext) {
				segments.add(LangUtils.wrap(this.visit(child)));
			}
		}

		return new FunctionNode(new SourceInfo(this, ctx), name, args.toArray(new String[args.size()]),
				segments.toArray(new LangNode[segments.size()]), defaults.toArray(new LangNode[defaults.size()]));
	}

	@Override
	public Object visitFunction(FunctionContext ctx) {

		return this.visitFunction(ctx, ctx.name);
	}

	@Override
	public Object visitOperatorFunction(OperatorFunctionContext ctx) {

		return this.visitFunction(ctx, ctx.name);

	}

	@Override
	public Object visitLambdaTerm(LambdaTermContext ctx) {

		List<String> formals = new ArrayList<String>();
		for (TerminalNode id : ctx.ID()) {
			formals.add(id.getText());
		}

		ParseTree segment = ctx.segment() == null ? ctx.term() : ctx.segment();

		LangNode node = LangUtils.wrap(this.visit(segment));

		return new LambdaTerm(new SourceInfo(this, ctx), formals.toArray(new String[formals.size()]), node);

	}

	@Override
	public Object visitJlambdaTerm(JlambdaTermContext ctx) {

		LangNode path = LangUtils.wrap(this.visit(ctx.term(0)));

		List<String> formals = new ArrayList<String>();

		List<TerminalNode> ids = ctx.ID();

		for (int i = 0, size = ids.size(); i < size; i++) {

			formals.add(ids.get(i).getText());
		}

		ParseTree segment = ctx.segment() == null ? ctx.term(1) : ctx.segment();

		LangNode node = LangUtils.wrap(this.visit(segment));

		LambdaTerm lambda = new LambdaTerm(new SourceInfo(this, ctx), formals.toArray(new String[formals.size()]),
				node);

		return new JavaLambdaTerm(new SourceInfo(this, ctx), path, lambda);

	}

	@Override
	public Object visitKlass(KlassContext ctx) {

		String name = ctx.ID().getText();

		List<KlassNameContext> klassNames = ctx.klassName();

		String[] supers = new String[klassNames.size()];

		for (int i = 0; i < supers.length; i++) {

			supers[i] = klassNames.get(i).getText();
		}

		List<SegmentContext> segmentList = ctx.segment();
		LangNode[] segments = new LangNode[segmentList.size()];

		for (int i = 0; i < segments.length; i++) {
			segments[i] = (LangNode) this.visit(segmentList.get(i));
		}

		List<FunctionContext> functionList = ctx.function();

		List<OperatorFunctionContext> operatorList = ctx.operatorFunction();

		FunctionNode[] functions = new FunctionNode[functionList.size() + operatorList.size()];

		for (int i = 0, size = functionList.size(); i < size; i++) {
			functions[i] = (FunctionNode) this.visit(functionList.get(i));
		}

		for (int i = 0, begin = functionList.size(), size = operatorList.size(); i < size; i++) {
			functions[i + begin] = (FunctionNode) this.visit(operatorList.get(i));
		}

		return new KlassNode(new SourceInfo(this, ctx), name, supers, segments, functions);

	}

	@Override
	public Object visitSource(SourceContext ctx) {

		List<LangNode> nodes = new ArrayList<LangNode>();

		for (ParseTree child : ctx.children) {

			if (child instanceof SegmentContext || child instanceof FunctionContext || child instanceof KlassContext) {

				nodes.add(LangUtils.wrap(this.visit(child)));
			}
		}

		return new SourceRoot(new SourceInfo(this, ctx), nodes.toArray(new LangNode[nodes.size()]));
	}

}
