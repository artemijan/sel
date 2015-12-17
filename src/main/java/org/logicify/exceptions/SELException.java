package org.logicify.exceptions;

/**
 * Created by artem on 12/16/15.
 */
public class SELException extends Exception {
    public SELException(String message) {
        super(message);
    }

    public SELException() {
        super();
    }

    public SELException(Exception e) {
        super(e);
    }

}
