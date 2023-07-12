package com.site.jpa.exception.applicationspecifiedexception;

public class CustomerCreationException extends GlobalException {
    public CustomerCreationException() {
    }

    public CustomerCreationException(String message) {
        super(message);
    }

    public CustomerCreationException(Throwable cause) {
        super(cause);
    }

    public CustomerCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
