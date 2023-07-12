package com.site.jpa.model.mapper;

import com.site.jpa.entity.Authority;
import com.site.jpa.entity.Resource;
import com.site.jpa.entity.Role;
import com.site.jpa.entity.Customer;
import com.site.jpa.model.AuthorityDTO;
import com.site.jpa.model.RoleDTO;
import com.site.jpa.model.UserDTO;

import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {


    default Customer toCustomer(UserDTO userDTO) {

        Set<Role> roles = userDTO.getRoles().stream().map(RoleDTO::getRole).map(Role::new).collect(Collectors.toSet());
        Set<Authority> authorities = userDTO.getAuthorities().stream().map(AuthorityDTO::getAuthority).map(Authority::new).collect(Collectors.toSet());

        Resource resource = new Resource(userDTO.getResource().getResource());

        Customer customer = Customer.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPasswordDTO().getPassword())
                .email(userDTO.getEmail())
                .authorities(authorities)
                .roles(roles)
                .resource(resource)
                .build();

        return customer;

    }

}
