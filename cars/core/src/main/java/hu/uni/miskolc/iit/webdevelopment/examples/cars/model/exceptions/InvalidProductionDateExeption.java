package hu.uni.miskolc.iit.webdevelopment.examples.cars.model.exceptions;

/**
 * Created by tothzs on 2017.11.24..
 */
public class InvalidProductionDateExeption extends Exception {

    public InvalidProductionDateExeption() {
    }

    public InvalidProductionDateExeption(String message) {
        super(message);
    }

    public InvalidProductionDateExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductionDateExeption(Throwable cause) {
        super(cause);
    }

    public InvalidProductionDateExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
