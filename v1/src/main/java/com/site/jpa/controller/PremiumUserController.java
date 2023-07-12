package com.site.jpa.controller;

import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.service.abstraction.interfaces.PremiumService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user/premium", method = {RequestMethod.PATCH, RequestMethod.PUT})
@Slf4j
public class PremiumUserController {

    private PremiumService service;

    @Autowired
    public PremiumUserController(@Qualifier("premiumCustomerServiceImpl") PremiumService service) {
        this.service = service;
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<String> welcome() {
        log.info(String.format("Method.[%s].HttpMethod.[%s] invoked", "Welcome", GetMapping.class.getSimpleName()));
        String body = service.welcome();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/gmr")
    @ResponseBody
    public ResponseEntity<String> getMeResource(@NotNull @RequestParam String username) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] invoked", "getMeResource", GetMapping.class.getSimpleName()));
        String body = service.getMeResource(username);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/pmr")
    @ResponseBody
    public ResponseEntity<Boolean> putMeResource(@NotNull @RequestParam String username, @NotNull @RequestBody ResourceDTO resource) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] invoked", "putMeResource", PutMapping.class.getSimpleName()));
        Boolean status = service.putMeResource(username, resource);
        return ResponseEntity.ok(status);
    }

    @PatchMapping("/pmp")
    @ResponseBody
    public ResponseEntity<Boolean> patchMePassword(@NotNull @RequestParam String username, @RequestBody PasswordDTO password) throws Exception {
        log.info(String.format("Method.[%s].HttpMethod.[%s] invoked", "patchMePassword", PatchMapping.class.getSimpleName()));
        Boolean status = service.patchMePassword(username, password);
        return ResponseEntity.ok(status);
    }
}
