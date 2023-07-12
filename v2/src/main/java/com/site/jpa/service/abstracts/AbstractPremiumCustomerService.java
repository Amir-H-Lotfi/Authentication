package com.site.jpa.service.abstracts;


import com.site.jpa.model.PasswordDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.PremiumCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractPremiumCustomerService implements PremiumCustomerService {

    protected UserRepository repository;
    protected PasswordEncoder passwordEncoder;


    public AbstractPremiumCustomerService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
}
