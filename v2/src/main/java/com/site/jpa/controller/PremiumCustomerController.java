package com.site.jpa.controller;

import com.site.jpa.exception.applicationspecifiedexception.GlobalException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.service.PremiumCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/user/premium", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.PATCH})
@Slf4j
public class PremiumCustomerController {

    private PremiumCustomerService service;

    @Autowired
    public PremiumCustomerController(@Qualifier(value = "premiumCustomerServiceImpl") PremiumCustomerService service) {
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

    @PutMapping("/pmr")
    public ResponseEntity putMeResource(Authentication authentication, @RequestBody ResourceDTO resourceDTO) throws GlobalException {

        String username = authentication.getName();
        service.putMeResource(username, resourceDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/pmp")
    public ResponseEntity patchMePassword(Authentication authentication, @RequestBody PasswordDTO passwordDTO) throws GlobalException {
        String username = authentication.getName();
        service.patchMePassword(username, passwordDTO);
        return ResponseEntity.ok().build();
    }

}
