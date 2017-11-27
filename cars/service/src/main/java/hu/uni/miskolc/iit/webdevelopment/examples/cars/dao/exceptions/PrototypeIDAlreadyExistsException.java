package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions;

/**
 * Created by tothzs on 2017.11.24..
 */
public class PrototypeIDAlreadyExistsException extends Exception {
    public PrototypeIDAlreadyExistsException() {
    }

    public PrototypeIDAlreadyExistsException(String message) {
        super(message);
    }

    public PrototypeIDAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrototypeIDAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public PrototypeIDAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
