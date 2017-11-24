package hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions;

/**
 * Created by tothzs on 2017.11.24..
 */
public class ExistingCarPrototypeException extends Exception {
    public ExistingCarPrototypeException() {
    }

    public ExistingCarPrototypeException(String message) {
        super(message);
    }

    public ExistingCarPrototypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingCarPrototypeException(Throwable cause) {
        super(cause);
    }

    public ExistingCarPrototypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
