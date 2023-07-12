package com.site.jpa.service.impl;

import com.site.jpa.entity.Customer;
import com.site.jpa.exception.PasswordUpdateFailureException;
import com.site.jpa.exception.ResourceFetchException;
import com.site.jpa.exception.ResourceUpdateFailureException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.AbstractPremiumCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PremiumCustomerServiceImpl extends AbstractPremiumCustomerService {


    @Autowired
    public PremiumCustomerServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public String getMeResource(@NotNull String username) throws Exception {
        Optional<Customer> optionalMe = repository.findByUsername(username);
        Customer customer = optionalMe.orElseThrow(ResourceFetchException::new);
        log.info(String.format("Premium.Customer[%s] received resource successfully", username));
        return customer.getResource().getResource();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean patchMePassword(@NotNull String username, @NotNull PasswordDTO password) throws Exception {
        Optional<Customer> optionalMe = repository.findByUsername(username);
        Customer me = optionalMe.orElseThrow(PasswordUpdateFailureException::new);
        me.setPassword(password.getPassword());
        repository.save(me);
        log.info(String.format("Premium.Customer[%s] just patch Password successfully", username));
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean putMeResource(@NotNull String username, @NotNull ResourceDTO resource) throws Exception {
        Optional<Customer> optionalMe = repository.findByUsername(username);
        Customer me = optionalMe.orElseThrow(ResourceUpdateFailureException::new);
        me.getResource().setResource(resource.getResource());
        log.info(String.format("Premium.Customer[%s] just put resource successfully", username));
        return true;
    }


}
