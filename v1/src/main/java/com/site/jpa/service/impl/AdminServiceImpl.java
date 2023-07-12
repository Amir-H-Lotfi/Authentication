package com.site.jpa.service.impl;

import com.site.jpa.exception.CustomerCreationException;
import com.site.jpa.model.CustomerDTO;
import com.site.jpa.model.mapper.CustomerDTOMapper;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstraction.AbstractAdminService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl extends AbstractAdminService {

    @Autowired
    public AdminServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public void putCustomer(@NotNull CustomerDTO customerDTO) throws Exception {
        try {
            var mapper = Mappers.getMapper(CustomerDTOMapper.class);
            var customer = mapper.from(customerDTO);
            repository.saveAndFlush(customer);
            log.debug(String.format("Customer.[%s] created", customerDTO));
        } catch (Exception e) {
            throw new CustomerCreationException();
        }
    }

    @Override
    public void deleteCustomer(@NotNull String username) throws Exception {
        try {
            Long count = repository.deleteByUsername(username);
            if (count == 0) {
                log.error(String.format("No Such Customer.[%s]", username));
                throw new Exception();
            }
            log.warn(String.format("Customer.[%s] removed", username));
        } catch (Exception e) {
            throw new CustomerCreationException();
        }
    }

}
