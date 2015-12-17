package org.logicify.common;

import org.logicify.exceptions.SELException;

/**
 * Created by artem on 12/10/15.
 */
public interface IExpressionHandler<T> {

    //    String name = null;
    String getName();

    IExpressionContext getContext();

    T parseArgument(Object rawArgumentValue) throws SELException;

    Object invoke(T argument, IExpressionContext context);
}
