// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link glacierParser}.
 */
public interface glacierListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link glacierParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFormula(glacierParser.FormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFormula(glacierParser.FormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#quantifiedFormula}.
	 * @param ctx the parse tree
	 */
	void enterQuantifiedFormula(glacierParser.QuantifiedFormulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#quantifiedFormula}.
	 * @param ctx the parse tree
	 */
	void exitQuantifiedFormula(glacierParser.QuantifiedFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(glacierParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(glacierParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(glacierParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(glacierParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(glacierParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(glacierParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(glacierParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(glacierParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(glacierParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(glacierParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(glacierParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(glacierParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#leftTerm}.
	 * @param ctx the parse tree
	 */
	void enterLeftTerm(glacierParser.LeftTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#leftTerm}.
	 * @param ctx the parse tree
	 */
	void exitLeftTerm(glacierParser.LeftTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#rightTerm}.
	 * @param ctx the parse tree
	 */
	void enterRightTerm(glacierParser.RightTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#rightTerm}.
	 * @param ctx the parse tree
	 */
	void exitRightTerm(glacierParser.RightTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#noValue}.
	 * @param ctx the parse tree
	 */
	void enterNoValue(glacierParser.NoValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#noValue}.
	 * @param ctx the parse tree
	 */
	void exitNoValue(glacierParser.NoValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#operationPrevious}.
	 * @param ctx the parse tree
	 */
	void enterOperationPrevious(glacierParser.OperationPreviousContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#operationPrevious}.
	 * @param ctx the parse tree
	 */
	void exitOperationPrevious(glacierParser.OperationPreviousContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(glacierParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(glacierParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#operationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterOperationSuffix(glacierParser.OperationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#operationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitOperationSuffix(glacierParser.OperationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#operationHeader}.
	 * @param ctx the parse tree
	 */
	void enterOperationHeader(glacierParser.OperationHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#operationHeader}.
	 * @param ctx the parse tree
	 */
	void exitOperationHeader(glacierParser.OperationHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#pathParameter}.
	 * @param ctx the parse tree
	 */
	void enterPathParameter(glacierParser.PathParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#pathParameter}.
	 * @param ctx the parse tree
	 */
	void exitPathParameter(glacierParser.PathParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#queryParameter}.
	 * @param ctx the parse tree
	 */
	void enterQueryParameter(glacierParser.QueryParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#queryParameter}.
	 * @param ctx the parse tree
	 */
	void exitQueryParameter(glacierParser.QueryParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#operationParameter}.
	 * @param ctx the parse tree
	 */
	void enterOperationParameter(glacierParser.OperationParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#operationParameter}.
	 * @param ctx the parse tree
	 */
	void exitOperationParameter(glacierParser.OperationParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#httpRequest}.
	 * @param ctx the parse tree
	 */
	void enterHttpRequest(glacierParser.HttpRequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#httpRequest}.
	 * @param ctx the parse tree
	 */
	void exitHttpRequest(glacierParser.HttpRequestContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(glacierParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(glacierParser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(glacierParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(glacierParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(glacierParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(glacierParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOperator(glacierParser.BooleanOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#booleanOperator}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOperator(glacierParser.BooleanOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(glacierParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(glacierParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#stringParam}.
	 * @param ctx the parse tree
	 */
	void enterStringParam(glacierParser.StringParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#stringParam}.
	 * @param ctx the parse tree
	 */
	void exitStringParam(glacierParser.StringParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(glacierParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(glacierParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(glacierParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(glacierParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(glacierParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(glacierParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#blockParameter}.
	 * @param ctx the parse tree
	 */
	void enterBlockParameter(glacierParser.BlockParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#blockParameter}.
	 * @param ctx the parse tree
	 */
	void exitBlockParameter(glacierParser.BlockParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(glacierParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(glacierParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#functionID}.
	 * @param ctx the parse tree
	 */
	void enterFunctionID(glacierParser.FunctionIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#functionID}.
	 * @param ctx the parse tree
	 */
	void exitFunctionID(glacierParser.FunctionIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#varID}.
	 * @param ctx the parse tree
	 */
	void enterVarID(glacierParser.VarIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#varID}.
	 * @param ctx the parse tree
	 */
	void exitVarID(glacierParser.VarIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link glacierParser#previousHeader}.
	 * @param ctx the parse tree
	 */
	void enterPreviousHeader(glacierParser.PreviousHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link glacierParser#previousHeader}.
	 * @param ctx the parse tree
	 */
	void exitPreviousHeader(glacierParser.PreviousHeaderContext ctx);
}