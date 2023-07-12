package com.site.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.jpa.entity.Role;
import com.site.jpa.model.AuthorityDTO;
import com.site.jpa.model.UserDTO;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;
import com.site.jpa.model.RoleDTO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
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

import jakarta.transaction.Transactional;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
class AdminUserControllerIntegrationTest {

    static String realUsername;
    static String realPassword;
    static String nonAdminUsername;
    static String nonAdminPassword;

    MockMvc mockMvc;

    ObjectMapper objectMapper;
    UriComponentsBuilder uriBuilder;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Value("${api.user.admin}")
    String path = "/user/admin";

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

            if (role.equals(Role.RoleType.USER$ADMIN.value) && flag == 0) {
                realUsername = record[1];
                realPassword = record[2];
                flag++;
            }
            if (role.equals(Role.RoleType.USER$PREMIUM.value) && flag == 1) {
                nonAdminUsername = record[1];
                nonAdminPassword = record[2];
                flag++;
            }
            if (flag == 2) {
                break;
            }
        }
    }

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
        uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http").host("localhost").port(port).encode();
    }

    @Test
    void welcome_authenticated() throws Exception {

        var uri = uriBuilder.path(path).build().toUri();

        var user = SecurityMockMvcRequestPostProcessors
                .httpBasic(realUsername, realPassword);

        var get = MockMvcRequestBuilders
                .get(uri)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    void welcome_forbidden() throws Exception {
        var uri = uriBuilder.path(path).build().toUri();

        var user = SecurityMockMvcRequestPostProcessors
                .httpBasic(nonAdminUsername, nonAdminPassword);

        var get = MockMvcRequestBuilders
                .get(uri)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    void welcome_unauthorized() throws Exception {
        var uri = uriBuilder.path(path).build().toUri();

        var username = "username";
        var password = "password";
        var user = SecurityMockMvcRequestPostProcessors
                .httpBasic(username, password);


        var get = MockMvcRequestBuilders
                .get(uri)
                .with(user);

        mockMvc.perform(get)
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());

    }

    @Test
    void putCustomer() throws Exception {
        var uri = uriBuilder.path(path + "/pc").build().toUri();

        var customerDTO = UserDTO.builder()
                .username("newUsername")
                .passwordDTO(new PasswordDTO("newPassword"))
                .email("newEmail@email.com")
                .authorities(List.of(AuthorityDTO.builder().authority("authority.read").build()))
                .roles(List.of(RoleDTO.builder().role("USER_DEFAULT").build()))
                .resource(ResourceDTO.builder().resource("message you can read,so learn java").build())
                .build();

        var content = objectMapper.writeValueAsString(customerDTO);


        var user = SecurityMockMvcRequestPostProcessors.httpBasic(realUsername, realPassword);

        var put = MockMvcRequestBuilders.put(uri)
                .characterEncoding(StandardCharsets.UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .with(user);

        mockMvc.perform(put)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }

    @Test
    void deleteCustomer() throws Exception {

        var uri = uriBuilder.path(path + "/dc").build().toUri();

        var user = SecurityMockMvcRequestPostProcessors.httpBasic(realUsername, realPassword);

        var delete = MockMvcRequestBuilders.delete(uri)
                .queryParam("username", nonAdminUsername)
                .with(user);

        mockMvc.perform(delete)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());

    }

    @Test
    void patchMePassword() throws Exception {
        var uri = uriBuilder.path(path + "/pmp").build().toUri();

        var user = SecurityMockMvcRequestPostProcessors.httpBasic(realUsername, realPassword);

        var passwordDTO = new PasswordDTO("newPassword");
        var content = objectMapper.writeValueAsString(passwordDTO);

        var patch = MockMvcRequestBuilders.patch(uri)
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