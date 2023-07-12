package com.site.jpa.authentication.service;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.site.jpa.entity.User;
import com.site.jpa.repository.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

class H2UserDetailsServiceUnitTest {
    @Mock
    UserRepository repository;

    @InjectMocks
    H2UserDetailsService service;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loadUserByUsername_RealMockUsername_ReturnUserDetails() {
        User user = Mockito.mock(User.class);

        BDDMockito.given(user.getUsername()).willReturn("username");
        BDDMockito.given(user.getPassword()).willReturn("password");
        BDDMockito.given(user.getRoles()).willReturn(Set.of());
        BDDMockito.given(user.getAuthorities()).willReturn(Set.of());

        when(repository.findUserByUsername(ArgumentMatchers.anyString())).thenReturn(Optional.of(user));

        UserDetails userDetails = service.loadUserByUsername(anyString());
        Assertions.assertEquals(userDetails.getUsername(), user.getUsername());
        Assertions.assertEquals(userDetails.getPassword(), user.getPassword());

    }

    @Test
    void loadByUsername_FakeMockUsername_ThrowUsernameNotFoundException() {
        when(repository.findUserByUsername(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername(anyString()));

    }

}