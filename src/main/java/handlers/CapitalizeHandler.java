package handlers;

import common.BaseExpressionHandler;
import common.IExpressionContext;

import java.util.List;

/**
 * Created by artem on 12/11/15.
 */
public class CapitalizeHandler extends BaseExpressionHandler{

    private static final String HANDLER_NAME = "upper";


    @Override
    public String getName() {
        return HANDLER_NAME;
    }

    @Override
    public Object parseArgument(Object rawArgumentValue) {
        return rawArgumentValue;
    }

    @Override
    public Object invoke(Object argument, IExpressionContext context) {
        return argument.toString().toUpperCase();
    }
}
