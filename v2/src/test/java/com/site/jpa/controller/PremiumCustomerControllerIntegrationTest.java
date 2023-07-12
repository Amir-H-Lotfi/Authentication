package com.site.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.jpa.entity.Role;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc(addFilters = false)
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PremiumCustomerControllerIntegrationTest {

    static String realUsername;
    static String realPassword;
    static String nonPremiumUsername;
    static String nonPremiumPassword;

    MockMvc mockMvc;
    UriComponentsBuilder uriComponentsBuilder;
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Value("${api.user.premium}")
    String path;

    @Value("${server.port}")
    Integer port;

    @BeforeAll
    static void initialize() {

        File file = new File("src/test/resources/data.csv");
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        CsvParser csvParser = new CsvParser(csvParserSettings);

        List<String[]> records = csvParser.parseAll(file);
        int flag = 0;
        for (Iterator<String[]> it = records.iterator(); it.hasNext(); ) {

            String[] record = it.next();
            String role = record[record.length - 1];

            if (role.equals(Role.RoleType.USER$PREMIUM.value) && flag == 0) {
                realUsername = record[1];
                realPassword = record[2];
                flag++;
            }
            if (role.equals(Role.RoleType.USER$DEFAULT.value) && flag == 1) {
                nonPremiumUsername = record[1];
                nonPremiumPassword = record[2];
                flag++;
            }
            if (flag == 2) {
                break;
            }
        }
    }

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        objectMapper = new ObjectMapper();

        uriComponentsBuilder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(port)
                .encode();
    }

    @Test
    @Order(0)
    void welcome_authenticated() throws Exception {
        var uri = uriComponentsBuilder.path(path).build().toUri();
        var user = SecurityMockMvcRequestPostProcessors.httpBasic(realUsername, realPassword);

        var get = MockMvcRequestBuilders
                .get(uri)
                .characterEncoding(StandardCharsets.UTF_8)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    @Order(1)
    void welcome_forbidden() throws Exception {

        var uri = uriComponentsBuilder.path(path).build().toUri();
        var user = SecurityMockMvcRequestPostProcessors.httpBasic(nonPremiumUsername, nonPremiumPassword);


        var get = MockMvcRequestBuilders
                .get(uri)
                .characterEncoding(StandardCharsets.UTF_8)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    @Order(2)
    void welcome_unauthorized() throws Exception {
        var uri = uriComponentsBuilder.path(path).build().toUri();
        var username = "username";
        var password = "password";
        var user = SecurityMockMvcRequestPostProcessors.httpBasic(username, password);


        var get = MockMvcRequestBuilders
                .get(uri)
                .characterEncoding(StandardCharsets.UTF_8)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    @Order(3)
    void getMeResource() throws Exception {
        var uri = uriComponentsBuilder.path(path + "/gmr").build().toUri();
        var user = SecurityMockMvcRequestPostProcessors
                .httpBasic(realUsername, realPassword);

        var get = MockMvcRequestBuilders
                .get(uri)
                .characterEncoding(StandardCharsets.UTF_8)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    @Order(4)
    void putMeResource() throws Exception {
        var uri = uriComponentsBuilder.path(path + "/pmr").build().toUri();

        var user = SecurityMockMvcRequestPostProcessors.httpBasic(realUsername, realPassword);

        var resourceDTO = ResourceDTO.builder().resource("i modified it, this is my new message").build();
        var content = objectMapper.writeValueAsString(resourceDTO);

        var put = MockMvcRequestBuilders
                .put(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding(StandardCharsets.UTF_8)
                .with(user);

        mockMvc.perform(put)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());

    }

    @Test
    @Order(5)
    void patchMePassword() throws Exception {

        var uri = uriComponentsBuilder.path(path + "/pmp").build().toUri();
        var user = SecurityMockMvcRequestPostProcessors
                .httpBasic(realUsername, realPassword);

        var passwordDTO = PasswordDTO.builder().password("newPassword").build();
        var content = objectMapper.writeValueAsString(passwordDTO);
        var patch = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .characterEncoding(StandardCharsets.UTF_8)

                .with(user);

        mockMvc.perform(patch)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }
}