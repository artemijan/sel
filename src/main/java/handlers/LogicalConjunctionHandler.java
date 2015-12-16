package handlers;

import common.IExpressionContext;

import java.util.List;

/**
 * Created by artem on 12/11/15.
 */
public class LogicalConjunctionHandler extends AbstractLogicalOperations<List<Boolean>> {

    private static final String HANDLER_NAME = "allOf";


    @Override
    public String getName() {
        return HANDLER_NAME;
    }

    public Object invoke(List<Boolean> argument, IExpressionContext context) {
        return argument.contains(false) ? false : true;
    }
}
