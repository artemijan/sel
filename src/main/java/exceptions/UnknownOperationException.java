package exceptions;

/**
 * Created by artem on 12/16/15.
 */
public class UnknownOperationException extends Exception {
    public UnknownOperationException() {
        super();
    }

    public UnknownOperationException(String message) {
        super(message);
    }
}
