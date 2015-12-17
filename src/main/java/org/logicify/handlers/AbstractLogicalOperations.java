package org.logicify.handlers;

import org.logicify.common.BaseExpressionHandler;
import org.logicify.exceptions.SELException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by artem on 12/11/15.
 */
public abstract class AbstractLogicalOperations<T> extends BaseExpressionHandler<T> {
    public T parseArgument(Object rawArgumentValue) throws SELException {
        List<Boolean> parsedValues = new ArrayList<Boolean>();
        String[] args = rawArgumentValue.toString().split(",");
        for (String val : args) {
            parsedValues.add(Boolean.valueOf(val));
        }
        return (T) parsedValues;
    }
}
