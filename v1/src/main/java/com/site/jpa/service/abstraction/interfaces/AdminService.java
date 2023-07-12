package com.site.jpa.service.abstraction.interfaces;

import com.site.jpa.model.CustomerDTO;

import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;

public interface AdminService {

    default String welcome() {
        return String.format("Welcome");
    }

    @Transactional(rollbackFor = Exception.class)
    void putCustomer(@NotNull CustomerDTO customerDTO) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void deleteCustomer(@NotNull String username) throws Exception;
}
