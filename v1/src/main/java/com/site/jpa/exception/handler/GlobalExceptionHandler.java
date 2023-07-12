package com.site.jpa.exception.handler;

import com.site.jpa.exception.CustomerCreationException;
import com.site.jpa.exception.CustomerRemovalException;
import com.site.jpa.exception.PasswordUpdateFailureException;
import com.site.jpa.exception.ResourceFetchException;
import com.site.jpa.exception.ResourceUpdateFailureException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ResourceFetchException.class})
    public ResponseEntity handleRFE(Exception e, WebRequest webRequest) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = {PasswordUpdateFailureException.class})
    public ResponseEntity handlePUFE(Exception e, WebRequest webRequest) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = {ResourceUpdateFailureException.class})
    public ResponseEntity handleRUFE(Exception e, WebRequest webRequest) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = {CustomerCreationException.class})
    public ResponseEntity handleCCE(Exception e, WebRequest webRequest) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = {CustomerRemovalException.class})
    public ResponseEntity handleCRE(Exception e, WebRequest webRequest) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }
}
