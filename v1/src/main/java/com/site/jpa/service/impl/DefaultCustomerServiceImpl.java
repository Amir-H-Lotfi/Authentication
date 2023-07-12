package com.site.jpa.service.impl;

import com.site.jpa.entity.Customer;
import com.site.jpa.exception.PasswordUpdateFailureException;
import com.site.jpa.exception.ResourceFetchException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.AbstractDefaultCustomerService;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class DefaultCustomerServiceImpl extends AbstractDefaultCustomerService {

    @Autowired
    public DefaultCustomerServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public String getMeResource(@NotNull String username) throws Exception {
        Optional<Customer> optionalMe = repository.findByUsername(username);
        Customer customer = optionalMe.orElseThrow(ResourceFetchException::new);
        log.info(String.format("Customer.[%s] get resource", username));
        return customer.getResource().getResource();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean patchMePassword(@NotNull String username, @NotNull PasswordDTO password) throws Exception {
        Optional<Customer> optionalMe = repository.findByUsername(username);
        Customer me = optionalMe.orElseThrow(PasswordUpdateFailureException::new);
        me.setPassword(password.getPassword());
        repository.save(me);
        log.info(String.format("Customer.[%s] patch password", username));
        return true;
    }
}
