package com.site.jpa.model.mapper;

import com.site.jpa.entity.Customer;
import com.site.jpa.model.CustomerDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerDTOMapper {

    default Customer from(CustomerDTO customerDTO) {

        var mapper = Mappers.getMapper(ResourceDTOMapper.class);

        var customer = new Customer();

        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customer.getPassword());
        customer.setEmail(customer.getEmail());

        customer.addResource(mapper.from(customerDTO.getResource()));

        return customer;
    }
}
