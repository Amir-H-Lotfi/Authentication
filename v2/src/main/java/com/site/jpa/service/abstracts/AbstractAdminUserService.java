package com.site.jpa.service.abstracts;

import com.site.jpa.repository.AuthorityRepository;
import com.site.jpa.repository.RoleRepository;
import com.site.jpa.repository.UserRepository;
import com.site.jpa.service.AdminUserService;

import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractAdminUserService implements AdminUserService {

    protected UserRepository userRepository;
    protected AuthorityRepository authorityRepository;
    protected RoleRepository roleRepository;

    protected PasswordEncoder passwordEncoder;


    public AbstractAdminUserService(UserRepository userRepository, AuthorityRepository authorityRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.roleRepository = roleRepository;

        this.passwordEncoder = passwordEncoder;
    }
}
