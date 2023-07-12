package com.site.jpa.exception.applicationspecifiedexception;

public class CustomerRemovalException extends GlobalException{
    public CustomerRemovalException() {
    }

    public CustomerRemovalException(String message) {
        super(message);
    }

    public CustomerRemovalException(String message, Throwable cause) {
        super(message, cause);
    }
}
