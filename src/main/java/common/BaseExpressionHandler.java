package common;

/**
 * Created by artem on 12/10/15.
 */
public abstract class BaseExpressionHandler<T> implements IExpressionHandler<T> {

    private IExpressionContext context = null;

    public IExpressionContext getContext() {
        return this.context;
    }
}
