package hu.iit.uni.miskolc.webdevelopment.tsp.service.exception;

public class CityAlreadyExistException extends Exception {

    public CityAlreadyExistException() {
    }

    public CityAlreadyExistException(String message) {
        super(message);
    }

    public CityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CityAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public CityAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
