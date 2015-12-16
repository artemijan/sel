package impl;

import common.IExpressionContext;
import common.IExpressionEvaluator;
import common.IExpressionHandler;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by artem on 12/11/15.
 */
public class DefaultEvaluator implements IExpressionEvaluator {

    private static final Integer RECURSION_LIMIT = 15;
    private static final Pattern EXPRESSION_REGEX = Pattern.compile("\\$(\\w[\\d\\w]*)(\\((.*)?\\))?");
    private IExpressionContext context = new DefaultExpressionContext();

    private static String cutUnbalanced(String exp) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                stack.push(i);
            } else if (exp.charAt(i) == ')') {
                if (stack.pop() == null) {
                    return exp.substring(0, i);
                } else if (stack.size() == 0) {
                    return exp.substring(0, i + 1);
                }
            }
        }
        return exp;
    }

    @Override
    public IExpressionContext getContext() {
        return this.context;
    }

    public Object evaluate(String expression) {
        return evaluate(expression, null, 0);
    }

    public Object evaluate(String expression, IExpressionContext localContext, Integer recursionLevel) {
        if (!(expression instanceof String)) {
            return expression;
        }
        if (recursionLevel > RECURSION_LIMIT) {
            throw new RuntimeException("Recursion level limit is reached.");
        }
        if (localContext == null) {
            localContext = this.context;
        } else {
            localContext.inherit(this.context);
        }
        IExpressionContext expressionContext;
        expressionContext = localContext;
        Object result = expression;
        Matcher match = EXPRESSION_REGEX.matcher(expression);
        while (match.find()) {
            Object expressionValue = null;
            String balanced = cutUnbalanced(match.group(0));
            if (!balanced.equals(match.group(0))) {
                match = EXPRESSION_REGEX.matcher(balanced);
                continue;
            }
            String fullMatch = match.group(0);
            String expressionName = match.group(1);

            Boolean isFunction = (match.group(2) != null && !match.group(2).equals(""));
            Object argument = null;
            String arg = match.group(3);
            IExpressionHandler handler = null;

            try {

                handler = expressionContext.getFunctionHandlerByName(expressionName);
                if (isFunction) {
                    argument = evaluate(arg, localContext, recursionLevel + 1);
                    argument = handler.parseArgument(argument);
                }else {
                    argument = handler.invoke(expression,localContext);
                }
                expressionValue = handler.invoke(argument, localContext);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result instanceof String && ((String) result).length() == fullMatch.length()) {
                result = expressionValue;
            } else if (result instanceof String) {
                String val = expressionValue != null ? expressionValue.toString() : "";
                result = (result.toString()).replaceFirst(Pattern.quote(fullMatch), val);
                match = EXPRESSION_REGEX.matcher(result.toString());
            } else {
                result = expressionValue;
            }
        }
        return result;
    }
}
