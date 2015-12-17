package org.logicify.common;

import org.logicify.exceptions.UnknownOperationException;

import java.util.List;

/**
 * Created by artem on 12/10/15.
 */

public interface IExpressionContext {

    /*
        values
     */
    void registerValue(String name, Object value);

    void updateValue(String name, Object value);

    Object unregisterValue(String name);

    /*
        org.logicify.handlers
     */
    void registerHandler(IExpressionHandler functionHandler);

    IExpressionHandler unregisterHandler(String name);

    List<IExpressionHandler> getHandlers();

    IExpressionHandler getFunctionHandlerByName(String handlerName) throws UnknownOperationException;

    void inherit(IExpressionContext parentContext);
}
