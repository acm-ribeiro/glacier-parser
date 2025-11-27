package glacier_parser;

import glacier_domain.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

import static java.util.stream.Collectors.toList;


@SuppressWarnings("deprecation")
public class VisitorOrientedParser {

    public Formula parse(String s) {
        CharStream charStream = new ANTLRInputStream(s);
        glacierLexer lexer = new glacierLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        glacierParser parser = new glacierParser(tokens);

        glacierVisitor visitor = new glacierVisitor();

        return visitor.visit(parser.formula());
    }


    private static class glacierVisitor extends glacierBaseVisitor<Formula> {
        @Override
        public Formula visitFormula(glacierParser.FormulaContext ctx) {
            QuantifiedFormulaVisitor quantifiedFormulaVisitor = new QuantifiedFormulaVisitor();
            QuantifiedFormula quantifiedFormula = ctx.quantifiedFormula() != null ? ctx.quantifiedFormula().accept(quantifiedFormulaVisitor) : null;

            BooleanExpressionVisitor booleanExpressionVisitor = new BooleanExpressionVisitor();
            BooleanExpression booleanExpression = ctx.booleanExpression() != null ? ctx.booleanExpression().accept(booleanExpressionVisitor) : null;

            return new Formula(quantifiedFormula, booleanExpression);
        }

        public static class QuantifiedFormulaVisitor extends glacierBaseVisitor<QuantifiedFormula> {
            @Override
            public QuantifiedFormula visitQuantifiedFormula(glacierParser.QuantifiedFormulaContext ctx) {
                QuantifierVisitor quantifierVisitor = new QuantifierVisitor();
                Quantifier quantifier = ctx.quantifier().accept(quantifierVisitor);

                VarsVisitor varsVisitor = new VarsVisitor();
                Variables vars = ctx.vars().accept(varsVisitor);

                BooleanExpressionVisitor booleanExpressionVisitor = new BooleanExpressionVisitor();
                BooleanExpression booleanExpression = ctx.booleanExpression() != null ? ctx.booleanExpression().accept(booleanExpressionVisitor) : null;

                QuantifiedFormulaVisitor quantifiedFormulaVisitor = new QuantifiedFormulaVisitor();
                QuantifiedFormula quantifiedFormula = ctx.quantifiedFormula() != null ? ctx.quantifiedFormula().accept(quantifiedFormulaVisitor) : null;

                return new QuantifiedFormula(quantifier, vars, booleanExpression, quantifiedFormula);
            }
        }

        public static class BooleanExpressionVisitor extends glacierBaseVisitor<BooleanExpression> {
            @Override
            public BooleanExpression visitBooleanExpression(glacierParser.BooleanExpressionContext ctx) {
                ClauseVisitor clauseVisitor = new ClauseVisitor();
                Clause clause = ctx.clause() != null ? ctx.clause().accept(clauseVisitor) : null;

                BooleanExpressionVisitor booleanExpressionVisitor = new BooleanExpressionVisitor();
                BooleanExpression left = ctx.booleanExpression(0) != null ? ctx.booleanExpression(0).accept(booleanExpressionVisitor) : null;
                BooleanExpression right = ctx.booleanExpression(1) != null ? ctx.booleanExpression(1).accept(booleanExpressionVisitor) : null;

                BooleanOperatorVisitor booleanOperatorVisitor = new BooleanOperatorVisitor();
                BooleanOperator op = ctx.booleanOperator() != null ? ctx.booleanOperator().accept(booleanOperatorVisitor) : null;

                return new BooleanExpression(clause, left, right, op);
            }

        }

        public static class QuantifierVisitor extends glacierBaseVisitor<Quantifier> {
            @Override
            public Quantifier visitQuantifier(glacierParser.QuantifierContext ctx) {
                String quantifier = ctx.getText();
                return new Quantifier(quantifier);
            }
        }

        public static class VarsVisitor extends glacierBaseVisitor<Variables> {
            @Override
            public Variables visitVars(glacierParser.VarsContext ctx) {
                String varID = ctx.varID().getText();

                CallVisitor callVisitor = new CallVisitor();
                Call call = ctx.call() != null ? ctx.call().accept(callVisitor) : null;

                VarsVisitor varsVisitor = new VarsVisitor();
                Variables vars = ctx.vars() != null ? ctx.vars().accept(varsVisitor) : null;

                return new Variables(varID, call, vars);
            }
        }

        public static class CallVisitor extends glacierBaseVisitor<Call> {
            @Override
            public Call visitCall(glacierParser.CallContext ctx) {
                OperationVisitor operationVisitor = new OperationVisitor();
                Operation operation = ctx.operation() != null ? ctx.operation().accept(operationVisitor) : null;

                OperationPreviousVisitor operationPreviousVisitor = new OperationPreviousVisitor();
                OperationPrevious operationPrevious = ctx.operationPrevious() != null ? ctx.operationPrevious().accept(operationPreviousVisitor) : null;

                return new Call(operation, operationPrevious);
            }
        }

        public static class ClauseVisitor extends glacierBaseVisitor<Clause> {
            @Override
            public Clause visitClause(glacierParser.ClauseContext ctx) {
                BooleanValueVisitor booleanValueVisitor = new BooleanValueVisitor();
                BooleanValue booleanValue = ctx.booleanValue() != null ? ctx.booleanValue().accept(booleanValueVisitor) : null;

                ComparisonVisitor comparisonVisitor = new ComparisonVisitor();
                Comparison comparison = ctx.comparison() != null ? ctx.comparison().accept(comparisonVisitor) : null;

                return new Clause(booleanValue, comparison);
            }
        }

        public static class BooleanValueVisitor extends glacierBaseVisitor<BooleanValue> {
            @Override
            public BooleanValue visitBooleanValue(@NotNull glacierParser.BooleanValueContext ctx) {
                String value = ctx.getText();
                return new BooleanValue(value);
            }
        }

        public static class BooleanOperatorVisitor extends glacierBaseVisitor<BooleanOperator> {
            @Override
            public BooleanOperator visitBooleanOperator(@NotNull glacierParser.BooleanOperatorContext ctx) {
                String operator = ctx.getText();
                return new BooleanOperator(operator);
            }
        }


        public static class ComparisonVisitor extends glacierBaseVisitor<Comparison> {
            @Override
            public Comparison visitComparison(@NotNull glacierParser.ComparisonContext ctx) {
                LeftTermVisitor leftTermVisitor = new LeftTermVisitor();
                RightTermVisitor rightTermVisitor = new RightTermVisitor();

                LeftTerm left = ctx.leftTerm().accept(leftTermVisitor);
                RightTerm right = ctx.rightTerm().accept(rightTermVisitor);

                ComparatorVisitor comparatorVisitor = new ComparatorVisitor();
                Comparator comparator = ctx.comparator().accept(comparatorVisitor);

                return new Comparison(left, right, comparator);
            }
        }

        public static class RightTermVisitor extends glacierBaseVisitor<RightTerm> {
            @Override
            public RightTerm visitRightTerm(@NotNull glacierParser.RightTermContext ctx) {
                LeftTermVisitor leftTermVisitor = new LeftTermVisitor();
                LeftTerm leftTerm = ctx.leftTerm() != null ? ctx.leftTerm().accept(leftTermVisitor) : null;

                String noValue = ctx.noValue() != null? ctx.noValue().getText() : null;
                String code = ctx.RESPONSE_CODE() != null ? ctx.RESPONSE_CODE().getText() : null;
                int responseCode = code != null ? Integer.parseInt(code) : -1;

                return new RightTerm(leftTerm, noValue, responseCode);
            }
        }


        public static class LeftTermVisitor extends glacierBaseVisitor<LeftTerm> {
            @Override
            public LeftTerm visitLeftTerm(@NotNull glacierParser.LeftTermContext ctx) {
                CallVisitor callVisitor = new CallVisitor();
                Call call = ctx.call() != null ? ctx.call().accept(callVisitor) : null;

                ParamVisitor paramVisitor = new ParamVisitor();
                Param param = ctx.param() != null ? ctx.param().accept(paramVisitor) : null;

                boolean hasCurls = ctx.LCURL() != null && ctx.RCURL() != null;

                return new LeftTerm(call, param, hasCurls);
            }
        }


        public static class ParamVisitor extends glacierBaseVisitor<Param> {
            @Override
            public Param visitParam(@NotNull glacierParser.ParamContext ctx) {
                Param p;

                if (ctx.INT() != null) {
                    try {
                        Integer intParam = Integer.parseInt(ctx.getText());
                        p = new Param(null, intParam, null);
                    } catch (NumberFormatException e) {
                        Long longParam = Long.parseLong(ctx.getText());
                        p = new Param(null, null, longParam);
                    }
                } else {
                    StringParamVisitor stringParamVisitor = new StringParamVisitor();
                    StringParam stringParam = ctx.stringParam() != null ? ctx.stringParam().accept(stringParamVisitor) : null;
                    p = new Param(stringParam, null, null);
                }

                return p;
            }
        }

        public static class ComparatorVisitor extends glacierBaseVisitor<Comparator> {
            @Override
            public Comparator visitComparator(@NotNull glacierParser.ComparatorContext ctx) {
                String comp = ctx.getText();
                return new Comparator(comp);
            }
        }


        public static class OperationPreviousVisitor extends glacierBaseVisitor<OperationPrevious> {
            @Override
            public OperationPrevious visitOperationPrevious(@NotNull glacierParser.OperationPreviousContext ctx) {
                PreviousHeaderVisitor previousHeaderVisitor = new PreviousHeaderVisitor();
                PreviousHeader previousHeader = ctx.previousHeader().accept(previousHeaderVisitor);

                OperationVisitor operationVisitor = new OperationVisitor();
                Operation operation = ctx.operation().accept(operationVisitor);

                return new OperationPrevious(previousHeader, operation);
            }
        }

        public static class OperationVisitor extends glacierBaseVisitor<Operation> {
            @Override
            public Operation visitOperation(@NotNull glacierParser.OperationContext ctx) {
                OperationHeaderVisitor operationHeaderVisitor = new OperationHeaderVisitor();
                OperationHeader operationHeader = ctx.operationHeader() != null ? ctx.operationHeader().accept(operationHeaderVisitor) : null;

                OperationParameterVisitor operationParameterVisitor = new OperationParameterVisitor();
                OperationParameter operationParameter = ctx.operationParameter() != null ? ctx.operationParameter().accept(operationParameterVisitor) : null;

                OperationSuffixVisitor operationSuffixVisitor = new OperationSuffixVisitor();
                OperationSuffix operationSuffix = ctx.operationSuffix() != null ? ctx.operationSuffix().accept(operationSuffixVisitor) : null;

                PathParamVisitor pathParamVisitor = new PathParamVisitor();
                PathParam pathParam = ctx.pathParameter() != null ? ctx.pathParameter().accept(pathParamVisitor) : null;

                QueryParameterVisitor queryParameterVisitor = new QueryParameterVisitor();
                QueryParam queryParam = ctx.queryParameter() != null ? ctx.queryParameter().accept(queryParameterVisitor) : null;

                return new Operation(operationHeader, operationParameter, operationSuffix, pathParam, queryParam);
            }
        }

        public static class PathParamVisitor extends glacierBaseVisitor<PathParam> {
            @Override
            public PathParam visitPathParameter(@NotNull glacierParser.PathParameterContext ctx) {
                String[] parts = ctx.getText().split("\\[");
                String num_str = parts[1].split("]")[0];
                int num = Integer.parseInt(num_str);

                return new PathParam("this", num);
            }
        }

        public static class OperationSuffixVisitor extends glacierBaseVisitor<OperationSuffix> {
            @Override
            public OperationSuffix visitOperationSuffix(@NotNull glacierParser.OperationSuffixContext ctx) {
                FunctionVisitor functionVisitor = new FunctionVisitor();
                Function function = ctx.function() != null ? ctx.function().accept(functionVisitor) : null;

                StringParamVisitor stringParamVisitor = new StringParamVisitor();
                StringParam stringParam = ctx.stringParam() != null ? ctx.stringParam().accept(stringParamVisitor) : null;

                return new OperationSuffix(function, stringParam);
            }
        }

        public static class StringParamVisitor extends glacierBaseVisitor<StringParam> {
            @Override
            public StringParam visitStringParam(@NotNull glacierParser.StringParamContext ctx) {
                String param = ctx.getText();
                return new StringParam(param);
            }
        }


        public static class PreviousHeaderVisitor extends glacierBaseVisitor<PreviousHeader> {
            @Override
            public PreviousHeader visitPreviousHeader(@NotNull glacierParser.PreviousHeaderContext ctx) {
                String header = ctx.getText();
                return new PreviousHeader(header);
            }
        }


        public static class FunctionVisitor extends glacierBaseVisitor<Function> {
            @Override
            public Function visitFunction(@NotNull glacierParser.FunctionContext ctx) {
                String id = ctx.functionID().getText();
                return new Function(id);
            }
        }


        public static class OperationParameterVisitor extends glacierBaseVisitor<OperationParameter> {
            @Override
            public OperationParameter visitOperationParameter(@NotNull glacierParser.OperationParameterContext ctx) {
                HTTPRequestVisitor httpRequestVisitor = new HTTPRequestVisitor();
                HTTPRequest httpRequest = ctx.httpRequest() != null ? ctx.httpRequest().accept(httpRequestVisitor) : null;
                String thisRequest = ctx.THIS() != null ? ctx.THIS().getText().toLowerCase() : null;

                return new OperationParameter(httpRequest, thisRequest);
            }
        }


        private static class OperationHeaderVisitor extends glacierBaseVisitor<OperationHeader> {
            @Override
            public OperationHeader visitOperationHeader(@NotNull glacierParser.OperationHeaderContext ctx) {
                String header = ctx.getText();
                return new OperationHeader(header);
            }
        }


        private static class HTTPRequestVisitor extends glacierBaseVisitor<HTTPRequest> {
            @Override
            public HTTPRequest visitHttpRequest(@NotNull glacierParser.HttpRequestContext ctx) {
                MethodVisitor methodVisitor = new MethodVisitor();
                Method method = ctx.method().accept(methodVisitor);

                UrlVisitor urlVisitor = new UrlVisitor();
                Url url = ctx.url().accept(urlVisitor);

                return new HTTPRequest(method, url);
            }
        }


        private static class MethodVisitor extends glacierBaseVisitor<Method> {
            @Override
            public Method visitMethod(@NotNull glacierParser.MethodContext ctx) {
                String method = ctx.getText();
                return new Method(method);
            }
        }


        private static class UrlVisitor extends glacierBaseVisitor<Url> {
            @Override
            public Url visitUrl(@NotNull glacierParser.UrlContext ctx) {
                SegmentVisitor segmentVisitor = new SegmentVisitor();

                List<Segment> segments = ctx.segment() != null ? ctx.segment()
                        .stream()
                        .map(segment -> segment.accept(segmentVisitor))
                        .collect(toList()) : null;

                return new Url(segments);
            }
        }


        private static class SegmentVisitor extends glacierBaseVisitor<Segment> {
            @Override
            public Segment visitSegment(@NotNull glacierParser.SegmentContext ctx) {
                BlockVisitor blockVisitor = new BlockVisitor();

                List<Block> blocks = ctx.block()
                        .stream()
                        .map(block -> block.accept(blockVisitor))
                        .collect(toList());

                return new Segment(blocks);
            }
        }

        private static class BlockVisitor extends glacierBaseVisitor<Block> {
            @Override
            public Block visitBlock(@NotNull glacierParser.BlockContext ctx) {
                Integer intBlock = null;
                String stringBlock = null;

                try {
                    intBlock = Integer.parseInt(ctx.getText());
                } catch (NumberFormatException e) {
                    stringBlock = ctx.getText();
                }

                BlockParameterVisitor parameterVisitor = new BlockParameterVisitor();
                BlockParameter blockParameter = ctx.blockParameter() != null ? ctx.blockParameter().accept(parameterVisitor) : null;

                OperationVisitor operationVisitor = new OperationVisitor();
                Operation operation = ctx.operation() != null ? ctx.operation().accept(operationVisitor) : null;

                return new Block(stringBlock, intBlock, blockParameter, operation);
            }
        }

        private static class QueryParameterVisitor extends glacierBaseVisitor<QueryParam> {
            @Override
            public QueryParam visitQueryParameter(@NotNull glacierParser.QueryParameterContext ctx) {
                String parameterName = ctx.getText().split("\\{")[1].replace("}", "");
                return new QueryParam("this", parameterName);
            }
        }

        private static class BlockParameterVisitor extends glacierBaseVisitor<BlockParameter> {
            @Override
            public BlockParameter visitBlockParameter(@NotNull glacierParser.BlockParameterContext ctx) {
                String parameter = ctx.getText();
                return new BlockParameter(parameter);
            }
        }

    }

}
