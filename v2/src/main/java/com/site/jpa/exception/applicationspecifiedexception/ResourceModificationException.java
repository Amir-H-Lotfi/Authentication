package com.site.jpa.exception.applicationspecifiedexception;

public class ResourceModificationException extends GlobalException{
    public ResourceModificationException() {
    }

    public ResourceModificationException(String message) {
        super(message);
    }

    public ResourceModificationException(Throwable cause) {
        super(cause);
    }

    public ResourceModificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
