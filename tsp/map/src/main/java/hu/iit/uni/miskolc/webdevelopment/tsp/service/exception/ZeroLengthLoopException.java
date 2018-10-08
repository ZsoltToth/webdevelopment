package hu.iit.uni.miskolc.webdevelopment.tsp.service.exception;

public class ZeroLengthLoopException extends Exception {

    public ZeroLengthLoopException() {
    }

    public ZeroLengthLoopException(String message) {
        super(message);
    }

    public ZeroLengthLoopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroLengthLoopException(Throwable cause) {
        super(cause);
    }

    public ZeroLengthLoopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
