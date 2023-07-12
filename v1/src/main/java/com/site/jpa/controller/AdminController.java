package com.site.jpa.controller;

import com.site.jpa.aop.Log;
import com.site.jpa.model.CustomerDTO;
import com.site.jpa.service.abstraction.interfaces.AdminService;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user/admin", method = {RequestMethod.PUT, RequestMethod.DELETE})
@Slf4j
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<String> welcome() {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "Welcome", GetMapping.class.getSimpleName()));
        String body = adminService.welcome();
        return ResponseEntity.ok(body);
    }

    @PutMapping("/pc")
    public ResponseEntity putCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "putCustomer", PutMapping.class.getSimpleName()));
        adminService.putCustomer(customerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/dc")
    public ResponseEntity deleteCustomer(@RequestParam String username) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "deleteCustomer", DeleteMapping.class.getSimpleName()));
        adminService.deleteCustomer(username);
        return ResponseEntity.ok().build();
    }

}
