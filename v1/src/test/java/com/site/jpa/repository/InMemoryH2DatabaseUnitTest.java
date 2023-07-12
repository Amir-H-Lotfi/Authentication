package com.site.jpa.repository;

import com.site.jpa.entity.Customer;

import org.assertj.core.api.Assertions;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@DataJpaTest
@Transactional
class InMemoryH2DatabaseUnitTest {

    @Resource
    private UserRepository repository;


    private String[] realUsernames = new String[]{
            "CUSTOMER0USERNAME",
            "CUSTOMER1USERNAME",
            "USER0USERNAME"
    };

    private String[] fakeUsername = new String[]{
            "CUSTOMER00USERNAME",
            "CUSTOMER11USERNAME",
            "USER00USERNAME"
    };

    @Test
    @Rollback
    void findRealUser_ReturnNonEmptyOptional() throws Exception {
        for (String username : realUsernames) {
            Optional<Customer> optionalCustomer = repository.findByUsername(username);
            Assertions.assertThat(optionalCustomer).isPresent();
        }
    }

    @Test
    @Rollback
    void findFakeUser_ReturnEmptyOptional() throws Exception {
        for (String username : fakeUsername) {
            Optional<Customer> optionalCustomer = repository.findByUsername(username);
            Assertions.assertThat(optionalCustomer).isEmpty();
        }

    }

    @Test
    @Rollback
    void deleteByUsername_ValidUsername() throws Exception {
        for (var username : realUsernames) {
            var count = repository.deleteByUsername(username);
            Assertions.assertThat(count).isEqualTo(1);
        }

    }

    @Test
    @Rollback
    void deleteByUsername_InvalidUsername() throws Exception {
        for (var username : fakeUsername) {
            var count = repository.deleteByUsername(username);
            Assertions.assertThat(count).isEqualTo(0);
        }
    }


}