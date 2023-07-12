package com.site.jpa.service.abstraction;


import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.interfaces.DefaultService;

public abstract class AbstractDefaultCustomerService implements DefaultService {

    protected UserRepository repository;

    public AbstractDefaultCustomerService(UserRepository repository) {
        this.repository = repository;
    }

}
