package org.logicify.impl;

import org.logicify.common.IExpressionContext;
import org.logicify.common.IExpressionHandler;
import org.logicify.exceptions.UnknownOperationException;
import org.logicify.handlers.LogicalConjunctionHandler;
import org.logicify.handlers.LogicalDisjunctionHandler;
import org.logicify.handlers.LogicalNotHandler;
import org.logicify.handlers.ValueHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by artem on 12/11/15.
 */
public class DefaultExpressionContext implements IExpressionContext {

    private Map<String, IExpressionHandler> handlers = new HashMap<String, IExpressionHandler>();
    private IExpressionContext parentContext;

    @Override
    public void registerValue(String name, Object value) {
        registerHandler(new ValueHandler(name, value));
    }

    @Override
    public void updateValue(String name, Object value) {
        try {
            ValueHandler valueHandler = (ValueHandler) getFunctionHandlerByName(name);
            valueHandler.setValue(value);
        } catch (UnknownOperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object unregisterValue(String name) {
        return null;
    }

    @Override
    public void registerHandler(IExpressionHandler functionHandler) {
        if (!handlers.containsKey(functionHandler.getName())) {
            handlers.put(functionHandler.getName(), functionHandler);
        }
    }

    @Override
    public IExpressionHandler unregisterHandler(String name) {
        return null;
    }

    @Override
    public List<IExpressionHandler> getHandlers() {
        return null;
    }

    @Override
    public IExpressionHandler getFunctionHandlerByName(String handlerName) throws UnknownOperationException {
        if (!this.handlers.containsKey(handlerName)) {
            if (parentContext != null) {
                return parentContext.getFunctionHandlerByName(handlerName);
            }
            throw new UnknownOperationException("Unknown handler " + handlerName);
        }
        return this.handlers.get(handlerName);
    }

    @Override
    public void inherit(IExpressionContext parentContext) {
        this.parentContext = parentContext;
    }

    public DefaultExpressionContext() {
        registerHandler(new LogicalConjunctionHandler());
        registerHandler(new LogicalDisjunctionHandler());
        registerHandler(new LogicalNotHandler());
    }
}
