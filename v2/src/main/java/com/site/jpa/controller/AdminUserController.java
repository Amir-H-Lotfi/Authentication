package com.site.jpa.controller;

import com.site.jpa.exception.applicationspecifiedexception.GlobalException;
import com.site.jpa.model.UserDTO;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.service.AdminUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/user/admin", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
@Slf4j
public class AdminUserController {

    private AdminUserService service;

    @Autowired
    public AdminUserController(@Qualifier("adminUserServiceImpl") AdminUserService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity welcome() {
        String body = service.welcome();
        log.info("Class=%s,Method=%s invoked"
                .formatted(getClass().getSimpleName(), "welcome"));
        return ResponseEntity.ok(body);
    }

    @PutMapping("/pc")
    public ResponseEntity putCustomer(@RequestBody UserDTO userDTO) throws GlobalException {
        service.putMeCustomer(userDTO);
        log.info("Class=%s,Method=%s invoked"
                .formatted(getClass().getSimpleName(), "putCustomer"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/dc")
    public ResponseEntity deleteCustomer(@RequestParam String username) throws GlobalException{
        service.deleteMeCustomer(username);
        log.info("Class=%s,Method=%s invoked"
                .formatted(getClass().getSimpleName(), "deleteCustomer"));
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/pmp")
    public ResponseEntity patchMePassword(Authentication authentication, @RequestBody PasswordDTO passwordDTO) throws GlobalException {
        String username = authentication.getName();
        service.patchMePassword(username, passwordDTO);
        log.info("Class=%s,Method=%s invoked"
                .formatted(getClass().getSimpleName(), "patchMePassword"));
        return ResponseEntity.ok().build();
    }


}
