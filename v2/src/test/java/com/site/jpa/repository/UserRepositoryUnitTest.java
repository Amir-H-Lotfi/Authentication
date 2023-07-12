package com.site.jpa.repository;

import com.site.jpa.entity.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Transactional
class UserRepositoryUnitTest {

    @Autowired
    UserRepository repository;

    static List<String> users;

    @BeforeAll
    static void initialize() {
        users = new ArrayList<>();
        File file = new File("src/test/resources/data.csv");
        CsvParser csvParser = new CsvParser(new CsvParserSettings());
        csvParser.iterateRecords(file).forEach(record -> {
            String column = record.getString("username");
            if (!column.equals("username"))
                users.add(column);
        });
    }

    @Test
    void findUserByUsername_RealUsername_WillFind() {
        for (String username : users) {
            Optional<User> optionalUser = repository.findUserByUsername(username);
            Assertions.assertThat(optionalUser).isPresent();
        }
    }

    @Test
    void findUserByUsername_FakerUsername_FindNothing() {
        for (String username : users) {
            Optional<User> optionalUser = repository.findUserByUsername(username + "fake.append");
            Assertions.assertThat(optionalUser).isEmpty();
        }
    }

    @Test
    @Rollback
    void deleteByUsername_RealUsername() {
        Integer size = repository.findAll().size();
        Assertions.assertThat(size).isGreaterThan(0);
        for (String username : users) {
            Long count = repository.deleteByUsername(username);
            Assertions.assertThat(count).isGreaterThanOrEqualTo(1);
        }
    }

    @Test
    @Rollback
    void deleteByUsername_FakeUsername() {
        Integer size = repository.findAll().size();
        Assertions.assertThat(size).isGreaterThan(0);
        for (String username : users) {
            Long count = repository.deleteByUsername(username + "fake.append");
            Assertions.assertThat(count).isEqualTo(0);
        }
    }
}