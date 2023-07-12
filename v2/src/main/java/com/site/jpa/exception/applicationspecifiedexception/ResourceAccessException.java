package com.site.jpa.exception.applicationspecifiedexception;

public class ResourceAccessException extends GlobalException{
    public ResourceAccessException() {
    }

    public ResourceAccessException(String message) {
        super(message);
    }

    public ResourceAccessException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
