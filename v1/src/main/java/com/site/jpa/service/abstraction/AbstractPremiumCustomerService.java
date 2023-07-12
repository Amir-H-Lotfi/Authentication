package com.site.jpa.service.abstraction;

import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.interfaces.PremiumService;

public abstract class AbstractPremiumCustomerService implements PremiumService {

    protected UserRepository repository;

    public AbstractPremiumCustomerService(UserRepository repository) {
        this.repository = repository;
    }

}
