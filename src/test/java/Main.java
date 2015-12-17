import org.logicify.common.IExpressionEvaluator;
import org.logicify.impl.DefaultEvaluator;

/**
 * Created by artem on 12/16/15.
 */
public class Main {
    public static void main(String[] args) {
        IExpressionEvaluator evaluator = new DefaultEvaluator();
        evaluator.getContext().registerHandler(new UserHandler());
        User user = new User("Artem", "Fedorov", 20);
        evaluator.getContext().registerValue("user", user);
        String st = "Hello $user: $isAdult($user) $not(true)";
        System.out.println(evaluator.evaluate(st));
    }
}
