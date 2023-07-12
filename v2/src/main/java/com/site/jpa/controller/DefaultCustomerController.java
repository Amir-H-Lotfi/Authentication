package com.site.jpa.controller;

import com.site.jpa.exception.applicationspecifiedexception.GlobalException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.service.DefaultCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/user/default", method = {RequestMethod.GET, RequestMethod.PATCH})
@Slf4j
public class DefaultCustomerController {

    private DefaultCustomerService service;

    @Autowired
    public DefaultCustomerController(@Qualifier(value = "defaultCustomerServiceImpl") DefaultCustomerService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity welcome() {
        String body = service.welcome();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/gmr")
    @ResponseBody
    public ResponseEntity getMeResource(Authentication authentication) throws GlobalException {
        String username = authentication.getName();
        String body = service.getMeResource(username);
        return ResponseEntity.ok(body);
    }

    @PatchMapping("/pmp")
    public ResponseEntity patchMePassword(Authentication authentication, @RequestBody PasswordDTO passwordDTO) throws GlobalException {
        String username = authentication.getName();
        service.patchMePassword(username, passwordDTO);
        return ResponseEntity.ok().build();
    }


}
