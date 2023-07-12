package com.site.jpa.authentication.service;

import com.site.jpa.entity.Authority;
import com.site.jpa.entity.Role;
import com.site.jpa.entity.User;
import com.site.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Transactional(readOnly = true)
public class H2UserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public H2UserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = repository.findUserByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            log.info(String.format("Class=%s,Method=%s.User loaded, username=%s",
                    getClass().getName(), "loadByUsername", username));

            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .authorities(user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority().value)).toList().toArray(new SimpleGrantedAuthority[0]))
                    .roles(user.getRoles().stream().map(role -> role.getRole().value).toList().toArray(new String[0]))
                    .build();

            log.info(String.format("Class=%s,Method=%s. UserDetails created, userDetails=%s"
                    , getClass().getName(), "loadByUsername", userDetails));

            return userDetails;
        } else {
            log.info(String.format("Class=%s,Method=%s,No such username=%s",
                    getClass().getName(), "loadByUsername", username));
            throw new UsernameNotFoundException("Username Not Found");
        }
    }
}
