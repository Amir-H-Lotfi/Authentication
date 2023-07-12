package com.site.jpa.exception.handler;

import com.site.jpa.exception.applicationspecifiedexception.CustomerCreationException;
import com.site.jpa.exception.applicationspecifiedexception.CustomerRemovalException;
import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceAccessException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceModificationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = CustomerCreationException.class)
    public Object handleCCE(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = CustomerRemovalException.class)
    public Object handleCRE(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = PasswordModificationException.class)
    public Object handlePME(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = ResourceAccessException.class)
    public Object handleRAE(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();

    }

    @ExceptionHandler(value = ResourceModificationException.class)
    public Object handleRME(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }
}
