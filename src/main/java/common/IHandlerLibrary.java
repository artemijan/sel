package common;

/**
 * Created by artem on 12/10/15.
 */
public interface IHandlerLibrary {
    String getName();
    void register(IExpressionContext context);
}
