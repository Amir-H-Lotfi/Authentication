package com.site.jpa.service.impl;

import com.site.jpa.entity.User;
import com.site.jpa.exception.applicationspecifiedexception.CustomerCreationException;
import com.site.jpa.exception.applicationspecifiedexception.CustomerRemovalException;
import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.UserDTO;
import com.site.jpa.model.mapper.UserDTOMapper;
import com.site.jpa.repository.AuthorityRepository;
import com.site.jpa.repository.RoleRepository;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.abstracts.AbstractAdminUserService;

import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class AdminUserServiceImpl extends AbstractAdminUserService {


    public AdminUserServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        super(userRepository, authorityRepository, roleRepository, passwordEncoder);
    }

    @Override
    public Boolean putMeCustomer(UserDTO userDTO) throws CustomerCreationException {
        try {

            UserDTOMapper mapper = Mappers.getMapper(UserDTOMapper.class);
            User user = mapper.toCustomer(userDTO);

            var cloneRoles = user.getRoles();
            var cloneAuthorities = user.getAuthorities();

            var roles = roleRepository.findAll().stream().filter(role -> cloneRoles.contains(role)).collect(Collectors.toSet());
            var authorities =authorityRepository.findAll().stream().filter(authority -> cloneAuthorities.contains(authority)).collect(Collectors.toSet());

            user.setRoles(roles);
            user.setAuthorities(authorities);

            userRepository.saveAndFlush(user);
            log.info("Class=%s,Method=%s,user created,user=%s"
                    .formatted(getClass().getName(), "putMeCustomer", userDTO));
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new CustomerCreationException(e);
        }
    }

    @Override
    public Boolean deleteMeCustomer(String username) throws CustomerRemovalException {
        long count = userRepository.deleteByUsername(username);
        if (count >= 1) {
            log.info("Class=%s,Method=%s. User deleted, username=%s"
                    .formatted(getClass().getName(), "deleteCustomer", username));
        } else {
            log.info("Class=%s,Method=%s. Failed to remove customer,username=%s"
                    .formatted(getClass().getName(), "deleteMeCustomer", username));
            throw new CustomerRemovalException();
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean patchMePassword(String username, PasswordDTO passwordDTO) throws PasswordModificationException {
        try {
            Optional<User> optionalMe = userRepository.findUserByUsername(username);
            if (optionalMe.isPresent()) { // it is always true
                User me = optionalMe.get();
                String password = passwordEncoder.encode(passwordDTO.getPassword());
                me.setPassword(password);
                userRepository.save(me);
                log.info(String.format("Class=%s,Method=%s. Password patch,username=%s"
                        , getClass().getName(), "patchMePassword", username));
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            log.info("Class=%s,Method=%s.Failed to modify password"
                    .formatted(getClass().getName(), "patchMePassword"));
            throw new PasswordModificationException(e);
        }
    }
}
