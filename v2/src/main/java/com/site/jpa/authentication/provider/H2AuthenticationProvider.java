package com.site.jpa.authentication.provider;

import com.site.jpa.authentication.service.H2UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class H2AuthenticationProvider implements AuthenticationProvider {

    private final H2UserDetailsService service;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public H2AuthenticationProvider(H2UserDetailsService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = service.loadUserByUsername(username);
        log.info(String.format("Class=%s,Method=%s,UserDetails loaded successfully, userDetails=%s",
                getClass().getName(), "authenticate", userDetails));

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            log.info(String.format("Class=%s,Method=%s, user authenticated,username=%s",
                    getClass().getName(), "authenticate", username));

            return new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()
            );
        } else {
            log.info(String.format("Class=%s,Method=%s, failed to authentication, username=%s",
                    getClass().getName(), "authenticate", username));
            throw new AuthenticationCredentialsNotFoundException("Failed to authenticate");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        Boolean status = UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        if (status) {
            log.info(String.format("Class=%s,Method=%s. authentication supported, authentication=%s",
                    getClass().getName(), "supports", authentication.getName()));
            return true;
        }
        log.info(String.format("Class=%s,Method=%s. authentication does not support, authentication=%s",
                getClass().getName(), "supports", authentication.getName()));
        return false;
    }

    public H2UserDetailsService getService() {
        return service;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
