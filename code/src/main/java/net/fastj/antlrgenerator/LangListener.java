// Generated from Lang.g4 by ANTLR 4.5.3
package net.fastj.antlrgenerator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(LangParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(LangParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#sourceUnused}.
	 * @param ctx the parse tree
	 */
	void enterSourceUnused(LangParser.SourceUnusedContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#sourceUnused}.
	 * @param ctx the parse tree
	 */
	void exitSourceUnused(LangParser.SourceUnusedContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(LangParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(LangParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#klass}.
	 * @param ctx the parse tree
	 */
	void enterKlass(LangParser.KlassContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#klass}.
	 * @param ctx the parse tree
	 */
	void exitKlass(LangParser.KlassContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#operatorFunction}.
	 * @param ctx the parse tree
	 */
	void enterOperatorFunction(LangParser.OperatorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#operatorFunction}.
	 * @param ctx the parse tree
	 */
	void exitOperatorFunction(LangParser.OperatorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterBlockSegment(LangParser.BlockSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitBlockSegment(LangParser.BlockSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterStatementSegment(LangParser.StatementSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitStatementSegment(LangParser.StatementSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterIfElseSegment(LangParser.IfElseSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitIfElseSegment(LangParser.IfElseSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dowhileSegmemt}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterDowhileSegmemt(LangParser.DowhileSegmemtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dowhileSegmemt}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitDowhileSegmemt(LangParser.DowhileSegmemtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterWhileSegment(LangParser.WhileSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitWhileSegment(LangParser.WhileSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code foreachSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterForeachSegment(LangParser.ForeachSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code foreachSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitForeachSegment(LangParser.ForeachSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterForSegment(LangParser.ForSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitForSegment(LangParser.ForSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code switchSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSwitchSegment(LangParser.SwitchSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code switchSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSwitchSegment(LangParser.SwitchSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trySegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterTrySegment(LangParser.TrySegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trySegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitTrySegment(LangParser.TrySegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterLockSegment(LangParser.LockSegmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lockSegment}
	 * labeled alternative in {@link LangParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitLockSegment(LangParser.LockSegmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(LangParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(LangParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStatment}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatment(LangParser.AssignStatmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStatment}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatment(LangParser.AssignStatmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(LangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(LangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code yieldStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(LangParser.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code yieldStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(LangParser.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(LangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(LangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(LangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(LangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code throwStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(LangParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code throwStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(LangParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterTermStatement(LangParser.TermStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termStatement}
	 * labeled alternative in {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitTermStatement(LangParser.TermStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBasicTerm(LangParser.BasicTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBasicTerm(LangParser.BasicTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterBinaryTerm(LangParser.BinaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitBinaryTerm(LangParser.BinaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotClassTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDotClassTerm(LangParser.DotClassTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotClassTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDotClassTerm(LangParser.DotClassTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code preSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPreSelfUnaryTerm(LangParser.PreSelfUnaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code preSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPreSelfUnaryTerm(LangParser.PreSelfUnaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code definedTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDefinedTerm(LangParser.DefinedTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code definedTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDefinedTerm(LangParser.DefinedTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPostSelfUnaryTerm(LangParser.PostSelfUnaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postSelfUnaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPostSelfUnaryTerm(LangParser.PostSelfUnaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterCastTerm(LangParser.CastTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitCastTerm(LangParser.CastTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterInTerm(LangParser.InTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitInTerm(LangParser.InTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterNewTerm(LangParser.NewTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitNewTerm(LangParser.NewTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterAssignTerm(LangParser.AssignTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitAssignTerm(LangParser.AssignTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLambdaTerm(LangParser.LambdaTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLambdaTerm(LangParser.LambdaTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisTerm(LangParser.ParenthesisTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisTerm(LangParser.ParenthesisTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterListTerm(LangParser.ListTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitListTerm(LangParser.ListTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIsTerm(LangParser.IsTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIsTerm(LangParser.IsTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globalIDTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterGlobalIDTerm(LangParser.GlobalIDTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globalIDTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitGlobalIDTerm(LangParser.GlobalIDTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterConstTerm(LangParser.ConstTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitConstTerm(LangParser.ConstTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indicesTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterIndicesTerm(LangParser.IndicesTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indicesTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitIndicesTerm(LangParser.IndicesTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterUnaryTerm(LangParser.UnaryTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitUnaryTerm(LangParser.UnaryTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveTerm(LangParser.PrimitiveTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveTerm(LangParser.PrimitiveTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterConditionTerm(LangParser.ConditionTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitConditionTerm(LangParser.ConditionTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code keywordTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterKeywordTerm(LangParser.KeywordTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code keywordTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitKeywordTerm(LangParser.KeywordTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDotTerm(LangParser.DotTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDotTerm(LangParser.DotTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMapTerm(LangParser.MapTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMapTerm(LangParser.MapTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invokeTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterInvokeTerm(LangParser.InvokeTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invokeTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitInvokeTerm(LangParser.InvokeTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDefaultTerm(LangParser.DefaultTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDefaultTerm(LangParser.DefaultTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jlambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterJlambdaTerm(LangParser.JlambdaTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jlambdaTerm}
	 * labeled alternative in {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitJlambdaTerm(LangParser.JlambdaTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#variantName}.
	 * @param ctx the parse tree
	 */
	void enterVariantName(LangParser.VariantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#variantName}.
	 * @param ctx the parse tree
	 */
	void exitVariantName(LangParser.VariantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#atomicObject}.
	 * @param ctx the parse tree
	 */
	void enterAtomicObject(LangParser.AtomicObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#atomicObject}.
	 * @param ctx the parse tree
	 */
	void exitAtomicObject(LangParser.AtomicObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#fullPath}.
	 * @param ctx the parse tree
	 */
	void enterFullPath(LangParser.FullPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#fullPath}.
	 * @param ctx the parse tree
	 */
	void exitFullPath(LangParser.FullPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#klassName}.
	 * @param ctx the parse tree
	 */
	void enterKlassName(LangParser.KlassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#klassName}.
	 * @param ctx the parse tree
	 */
	void exitKlassName(LangParser.KlassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#keyWords}.
	 * @param ctx the parse tree
	 */
	void enterKeyWords(LangParser.KeyWordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#keyWords}.
	 * @param ctx the parse tree
	 */
	void exitKeyWords(LangParser.KeyWordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#operators}.
	 * @param ctx the parse tree
	 */
	void enterOperators(LangParser.OperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#operators}.
	 * @param ctx the parse tree
	 */
	void exitOperators(LangParser.OperatorsContext ctx);
}