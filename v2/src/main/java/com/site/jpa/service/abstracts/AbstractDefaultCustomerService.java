package com.site.jpa.service.abstracts;


import com.site.jpa.model.PasswordDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.DefaultCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractDefaultCustomerService implements DefaultCustomerService {
    protected UserRepository repository;
    protected PasswordEncoder passwordEncoder ;
    public AbstractDefaultCustomerService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder ;
    }
}
