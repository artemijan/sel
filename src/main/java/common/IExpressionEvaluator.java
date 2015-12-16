package common;

import java.util.Objects;

/**
 * Created by artem on 12/11/15.
 */
public interface IExpressionEvaluator {
    IExpressionContext getContext();

    Object evaluate(String expression);
}
