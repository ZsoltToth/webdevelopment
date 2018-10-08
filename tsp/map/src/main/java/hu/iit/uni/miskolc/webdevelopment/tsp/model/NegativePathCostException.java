package hu.iit.uni.miskolc.webdevelopment.tsp.model;

public class NegativePathCostException extends Exception {

    public NegativePathCostException() {
    }

    public NegativePathCostException(String message) {
        super(message);
    }

    public NegativePathCostException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativePathCostException(Throwable cause) {
        super(cause);
    }

    public NegativePathCostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
