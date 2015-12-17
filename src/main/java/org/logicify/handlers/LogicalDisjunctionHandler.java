package org.logicify.handlers;

import org.logicify.common.IExpressionContext;

import java.util.List;

/**
 * Created by artem on 12/11/15.
 */
public class LogicalDisjunctionHandler extends AbstractLogicalOperations<List<Boolean>> {

    private static final String HANDLER_NAME = "anyOf";


    @Override
    public String getName() {
        return HANDLER_NAME;
    }

    @Override
    public Object invoke(List<Boolean> argument, IExpressionContext context) {
        return argument.contains(true);
    }
}
