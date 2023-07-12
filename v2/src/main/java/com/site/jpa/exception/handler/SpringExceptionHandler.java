package com.site.jpa.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class SpringExceptionHandler {

    @ExceptionHandler(value = AuthenticationCredentialsNotFoundException.class)
    public Object handleACNFE(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public Object handleUNFE(Exception e, WebRequest webRequest) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }


}
