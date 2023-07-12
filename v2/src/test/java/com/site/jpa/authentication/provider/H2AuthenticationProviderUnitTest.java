package com.site.jpa.authentication.provider;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.site.jpa.authentication.service.H2UserDetailsService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintStream;
import java.util.List;


@SpringBootTest
class H2AuthenticationProviderUnitTest {

    @MockBean
    H2UserDetailsService service;

    @MockBean
    PasswordEncoder passwordEncoder;

    @MockBean
    Authentication mockAuthentication;

    @Mock
    UserDetails userDetails;

    @Autowired
    H2AuthenticationProvider provider;


    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);

        when(userDetails.getUsername()).thenReturn("username");
        when(userDetails.getPassword()).thenReturn("credentials");
        when(userDetails.getAuthorities()).thenReturn(List.of());

        when(service.loadUserByUsername(anyString())).thenReturn(userDetails);

        when(mockAuthentication.getName()).thenReturn("username");
        when(mockAuthentication.getCredentials()).thenReturn("credentials");
    }

    @Test
    void authenticate_AuthenticateRealMockUser_ReturnAuthentication() {
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(Boolean.TRUE);
        Authentication authentication = provider.authenticate(mockAuthentication);
        Assertions.assertEquals(authentication.getName(), mockAuthentication.getName());
        Assertions.assertEquals(authentication.getCredentials(), mockAuthentication.getCredentials());
        Assertions.assertIterableEquals(authentication.getAuthorities(), mockAuthentication.getAuthorities());

    }

    @Test
    void authenticate_AuthenticateFakeMockUser_ThrowAuthenticationCredentialsNotFoundException() {
       when(passwordEncoder.matches(anyString() , anyString())).thenReturn(Boolean.FALSE);
        Assertions.assertThrows(AuthenticationCredentialsNotFoundException.class, () -> provider.authenticate(mockAuthentication));
    }
}