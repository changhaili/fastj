// Generated from Lang.g4 by ANTLR 4.5.3
package net.fastj.antlrgenerator;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(LangParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#sourceUnused}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceUnused(LangParser.SourceUnusedContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(LangParser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#klass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlass(LangParser.KlassContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#operatorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorFunction(LangParser.OperatorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LangParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSegment(LangParser.BlockSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSegment(LangParser.StatementSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElseSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseSegment(LangParser.IfElseSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dowhileSegmemt}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhileSegmemt(LangParser.DowhileSegmemtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSegment(LangParser.WhileSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreachSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeachSegment(LangParser.ForeachSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForSegment(LangParser.ForSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code switchSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchSegment(LangParser.SwitchSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trySegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrySegment(LangParser.TrySegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockSegment(LangParser.LockSegmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(LangParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStatment}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatment(LangParser.AssignStatmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(LangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code yieldStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(LangParser.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(LangParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(LangParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code throwStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(LangParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermStatement(LangParser.TermStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicTerm(LangParser.BasicTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryTerm(LangParser.BinaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotClassTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotClassTerm(LangParser.DotClassTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code preSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreSelfUnaryTerm(LangParser.PreSelfUnaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definedTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinedTerm(LangParser.DefinedTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostSelfUnaryTerm(LangParser.PostSelfUnaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code castTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastTerm(LangParser.CastTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInTerm(LangParser.InTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTerm(LangParser.NewTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignTerm(LangParser.AssignTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaTerm(LangParser.LambdaTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisTerm(LangParser.ParenthesisTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListTerm(LangParser.ListTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsTerm(LangParser.IsTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalIDTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalIDTerm(LangParser.GlobalIDTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstTerm(LangParser.ConstTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indicesTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndicesTerm(LangParser.IndicesTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryTerm(LangParser.UnaryTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveTerm(LangParser.PrimitiveTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionTerm(LangParser.ConditionTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code keywordTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordTerm(LangParser.KeywordTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotTerm(LangParser.DotTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mapTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapTerm(LangParser.MapTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invokeTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeTerm(LangParser.InvokeTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultTerm(LangParser.DefaultTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jlambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJlambdaTerm(LangParser.JlambdaTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#variantName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariantName(LangParser.VariantNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#atomicObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicObject(LangParser.AtomicObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#fullPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullPath(LangParser.FullPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#klassName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlassName(LangParser.KlassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#keyWords}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyWords(LangParser.KeyWordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#operators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperators(LangParser.OperatorsContext ctx);
}