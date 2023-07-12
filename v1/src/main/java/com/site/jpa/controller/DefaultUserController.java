package com.site.jpa.controller;

import com.site.jpa.model.PasswordDTO;
import com.site.jpa.service.abstraction.interfaces.DefaultService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/default", method = {RequestMethod.PATCH})
@Slf4j
public class DefaultUserController {

    private DefaultService service;

    @Autowired
    public DefaultUserController(@Qualifier("defaultCustomerServiceImpl") DefaultService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> welcome() {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "Welcome", GetMapping.class.getSimpleName()));
        String body = service.welcome();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/gmr")
    @ResponseBody
    public ResponseEntity<String> getMeResource(@NotNull @RequestParam String username) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "getMeResource", GetMapping.class.getSimpleName()));
        String body = service.getMeResource(username);
        return ResponseEntity.ok(body);
    }

    @PatchMapping("/pmp")
    @ResponseBody
    public ResponseEntity<Boolean> patchMePassword(@NotNull @RequestParam String username, @RequestBody PasswordDTO password) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] Call", "patchMePassword", PatchMapping.class.getSimpleName()));
        Boolean status = service.patchMePassword(username, password);
        return ResponseEntity.ok(status);
    }
}
