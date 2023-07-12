package com.site.jpa.service;

import com.site.jpa.entity.User;
import com.site.jpa.exception.applicationspecifiedexception.CustomerRemovalException;
import com.site.jpa.exception.applicationspecifiedexception.GlobalException;
import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.model.AuthorityDTO;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.model.RoleDTO;
import com.site.jpa.model.UserDTO;
import com.site.jpa.repository.AuthorityRepository;
import com.site.jpa.repository.RoleRepository;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.impl.AdminUserServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
class AdminUserServiceUnitTest {

    @Mock
    User user;

    @Mock
    UserRepository userRepository;
    @Mock
    AuthorityRepository authorityRepository;
    @Mock
    RoleRepository roleRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    AdminUserService adminUserService;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
        adminUserService = new AdminUserServiceImpl(userRepository, authorityRepository, roleRepository, passwordEncoder);
    }

    @Test
    void welcome() {
        String welcome = adminUserService.welcome();
        Assertions.assertEquals(welcome, "Welcome");
    }

    @Test
    void putCustomer() throws GlobalException {

        UserDTO userDTO = UserDTO
                .builder()
                .username("username")
                .passwordDTO(new PasswordDTO("newPassword"))
                .authorities(List.of(new AuthorityDTO("authority.read")))
                .roles(List.of(new RoleDTO("USER_DEFAULT")))
                .resource(new ResourceDTO("Message you can read"))
                .build();
        Assertions.assertTrue(adminUserService.putMeCustomer(userDTO));
    }

    @Test
    void deleteCustomer() throws GlobalException {
        when(userRepository.deleteByUsername(anyString())).thenReturn(1l);
        Boolean result = adminUserService.deleteMeCustomer("any string");
        Assertions.assertTrue(result);
    }

    @Test
    void deleteCustomer_throwException() throws GlobalException {
        when(userRepository.deleteByUsername(anyString())).thenReturn(0l);
        Assertions.assertThrows(CustomerRemovalException.class, () -> adminUserService.deleteMeCustomer("anyusername"));
    }

    @Test
    void patchMePassword() throws GlobalException {
        when(userRepository.findUserByUsername(anyString())).thenReturn(Optional.of(user));
        Boolean result = adminUserService.patchMePassword("username", new PasswordDTO("password"));
        Assertions.assertTrue(result);
    }

    @Test
    void patchMePassword_throwException() throws GlobalException {
        when(userRepository.findUserByUsername(anyString())).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(PasswordModificationException.class, () -> adminUserService.patchMePassword("username", new PasswordDTO("password")));
    }


}