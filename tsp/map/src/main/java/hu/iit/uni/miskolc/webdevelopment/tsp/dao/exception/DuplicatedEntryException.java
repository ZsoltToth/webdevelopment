package hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception;

public class DuplicatedEntryException extends Exception {

    public DuplicatedEntryException() {
    }

    public DuplicatedEntryException(String message) {
        super(message);
    }

    public DuplicatedEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedEntryException(Throwable cause) {
        super(cause);
    }

    public DuplicatedEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
