package parser;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link glacierParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface glacierVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link glacierParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(glacierParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#quantifiedFormula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifiedFormula(glacierParser.QuantifiedFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(glacierParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(glacierParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(glacierParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(glacierParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(glacierParser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(glacierParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#leftTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftTerm(glacierParser.LeftTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#rightTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightTerm(glacierParser.RightTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#noValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoValue(glacierParser.NoValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#operationPrevious}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationPrevious(glacierParser.OperationPreviousContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(glacierParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#operationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationSuffix(glacierParser.OperationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#operationHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationHeader(glacierParser.OperationHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#pathParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathParameter(glacierParser.PathParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#queryParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryParameter(glacierParser.QueryParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#operationParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationParameter(glacierParser.OperationParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#httpRequest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHttpRequest(glacierParser.HttpRequestContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(glacierParser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(glacierParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(glacierParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#booleanOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOperator(glacierParser.BooleanOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(glacierParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#stringParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringParam(glacierParser.StringParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(glacierParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#segment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSegment(glacierParser.SegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(glacierParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#blockParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockParameter(glacierParser.BlockParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(glacierParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#functionID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionID(glacierParser.FunctionIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#varID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarID(glacierParser.VarIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link glacierParser#previousHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreviousHeader(glacierParser.PreviousHeaderContext ctx);
}