package com.site.jpa.exception.applicationspecifiedexception;

public class GlobalException extends Exception {

    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
}
