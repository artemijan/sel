package common;

import exceptions.SELException;

import java.util.List;
import java.util.Objects;

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
