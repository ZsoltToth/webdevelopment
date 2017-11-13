package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions;

/**
 * Created by tothzs on 2017.11.13..
 */
public class CarRecordAlreadyExistsException extends Exception {
    public CarRecordAlreadyExistsException() {
    }

    public CarRecordAlreadyExistsException(String message) {
        super(message);
    }

    public CarRecordAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarRecordAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public CarRecordAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
