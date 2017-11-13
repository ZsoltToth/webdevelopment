package hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions;

/**
 * Created by tothzs on 2017.11.13..
 */
public class ExistingPlateNumber extends Exception {
    public ExistingPlateNumber() {
    }

    public ExistingPlateNumber(String message) {
        super(message);
    }

    public ExistingPlateNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistingPlateNumber(Throwable cause) {
        super(cause);
    }

    public ExistingPlateNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
