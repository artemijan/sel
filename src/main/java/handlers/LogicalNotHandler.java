package handlers;

import common.BaseExpressionHandler;
import common.IExpressionContext;
import exceptions.SELException;

import java.util.List;

/**
 * Created by artem on 12/11/15.
 */
public class LogicalNotHandler extends BaseExpressionHandler<Boolean> {

    private static final String HANDLER_NAME = "not";


    @Override
    public String getName() {
        return HANDLER_NAME;
    }

    @Override
    public Boolean parseArgument(Object rawArgumentValue) throws SELException {
        try {
            return Boolean.valueOf(rawArgumentValue.toString());
        } catch (IllegalArgumentException e) {
            throw new SELException("Error while parsing an argument by handler " + HANDLER_NAME + ". Argument should be a boolean value.");
        }
    }


    public Object invoke(Boolean argument, IExpressionContext context) {
        return argument.equals(true) ? false : true;
    }
}
