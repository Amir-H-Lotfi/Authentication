package com.site.jpa.service;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.site.jpa.entity.Resource;
import com.site.jpa.entity.Customer;
import com.site.jpa.exception.applicationspecifiedexception.GlobalException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.impl.DefaultCustomerServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
class DefaultCustomerServiceUnitTest {

    @Mock
    Customer customer;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    UserRepository repository;

    @InjectMocks
    DefaultCustomerServiceImpl service;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMeResource() throws GlobalException {

        Resource resource = new Resource(-1, "Message you can read");
        when(repository.findUserByUsername(anyString())).thenReturn(Optional.of(customer));
        when(customer.getResource()).thenReturn(resource);
        Assertions.assertEquals(service.getMeResource("any username"), resource.getResource());

    }

    @Test
    void patchMePassword() throws GlobalException {
        when(repository.findUserByUsername(anyString())).thenReturn(Optional.of(customer));
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        Assertions.assertTrue(service.patchMePassword("any username", new PasswordDTO("mockPassword")));
    }

}