package com.site.jpa.exception.applicationspecifiedexception;

public class PasswordModificationException extends GlobalException{
    public PasswordModificationException() {
    }

    public PasswordModificationException(String message) {
        super(message);
    }

    public PasswordModificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordModificationException(Throwable cause) {
        super(cause);
    }
}
