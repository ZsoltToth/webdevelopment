package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions;

/**
 * Created by tothzs on 2017.11.26..
 */
public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(Throwable cause) {
        super(cause);
    }

    public CarNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
