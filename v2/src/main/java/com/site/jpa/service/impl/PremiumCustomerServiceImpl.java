package com.site.jpa.service.impl;

import com.site.jpa.entity.Customer;
import com.site.jpa.entity.User;
import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceAccessException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstracts.AbstractPremiumCustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class PremiumCustomerServiceImpl extends AbstractPremiumCustomerService {


    @Autowired
    public PremiumCustomerServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository, passwordEncoder);
    }

    @Override
    public String getMeResource(String username) throws ResourceAccessException {
        try {

            String resource = null;
            Optional<User> optionalUser = repository.findUserByUsername(username);
            if (optionalUser.isPresent()) {
                Customer customer = (Customer) optionalUser.get();
                resource = customer.getResource().getResource();
                log.info("Class=%s,Method=%s, User got resources, username=%s"
                        .formatted(getClass().getName(), "getMeResource", username));
            }
            return resource;
        } catch (Exception e) {
            throw new ResourceAccessException(e);
        }
    }

    @Override
    public Boolean putMeResource(String username, ResourceDTO resourceDTO) throws ResourceModificationException {
        try {

            Optional<User> optionalUser = repository.findUserByUsername(username);
            if (optionalUser.isPresent()) {
                Customer customer = (Customer) optionalUser.get();
                customer.getResource().setResource(resourceDTO.getResource());
                repository.save(customer);
                log.info("Class=%s,Method=%s, Resource updated, username=%s"
                        .formatted(getClass().getName(), "putMeResource", username));
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            throw new ResourceModificationException(e);
        }
    }

    @Override
    public Boolean patchMePassword(String username, PasswordDTO passwordDTO) throws PasswordModificationException {
        try {

            Optional<User> optionalUser = repository.findUserByUsername(username);
            if (optionalUser.isPresent()) {
                Customer customer = (Customer) optionalUser.get();
                String password = passwordEncoder.encode(passwordDTO.getPassword());
                customer.setPassword(password);
                repository.save(customer);
                log.info("Class=%s,Method=%s, password updated, username=%s"
                        .formatted(getClass().getName(), "patchMePassword", username));
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            throw new PasswordModificationException(e);
        }
    }
}
