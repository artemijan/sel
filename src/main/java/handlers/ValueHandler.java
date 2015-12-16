package handlers;

import common.AbstractValueHandler;
import common.IExpressionContext;

/**
 * Created by artem on 12/11/15.
 */
public class ValueHandler extends AbstractValueHandler {
    private Object value;
    private String name;

    public ValueHandler(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object invoke(Object argument, IExpressionContext context) {
        return value;
    }
}
