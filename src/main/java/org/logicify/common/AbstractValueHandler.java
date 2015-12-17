package org.logicify.common;

import org.logicify.exceptions.SELException;

/**
 * Created by artem on 12/16/15.
 */
public abstract class AbstractValueHandler<T> extends BaseExpressionHandler<T> {
    /**
     * All values shouldn't contain any arguments
     * @param rawArgumentValue
     * @return
     * @throws SELException
     */
    @Override
    public T parseArgument(Object rawArgumentValue) throws SELException {
        if (rawArgumentValue != null) {
            throw new SELException(getName() + "Shouldn't get any arguments");
        }
        return null;
    }
}
