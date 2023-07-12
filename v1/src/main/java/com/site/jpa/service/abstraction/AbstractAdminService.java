package com.site.jpa.service.abstraction;

import com.site.jpa.entity.Customer;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.interfaces.AdminService;

public abstract class AbstractAdminService implements AdminService {
    protected UserRepository<Customer> repository ;

    public AbstractAdminService(UserRepository repository){
        this.repository = repository;
    }

}
