import common.BaseExpressionHandler;
import common.IExpressionContext;
import exceptions.SELException;

/**
 * Created by artem on 12/16/15.
 */
public class UserHandler extends BaseExpressionHandler<User> {
    private static final String HANDLER_NAME = "isAdult";

    @Override
    public String getName() {
        return HANDLER_NAME;
    }

    @Override
    public User parseArgument(Object rawArgumentValue) throws SELException {
        return (User)rawArgumentValue;
    }


    @Override
    public Object invoke(User argument, IExpressionContext context) {
        return argument.isAdult();
    }
}
