package io.github.swar_101.maskit4j.exception;

public class MasKit4jPropertiesException extends RuntimeException {
    public MasKit4jPropertiesException() {
    }

    public MasKit4jPropertiesException(Throwable cause) {
        super(cause);
    }

    public MasKit4jPropertiesException(String message) {
        super(message);
    }

    public MasKit4jPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }

    public MasKit4jPropertiesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
