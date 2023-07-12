package com.site.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.jpa.model.CustomerDTO;
import com.site.jpa.model.ResourceDTO;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional(readOnly = true)
class AdminControllerIntegrationTest {

    private static ObjectMapper objectMapper;

    private static UriComponentsBuilder uriBuilder;
    private static CloseableHttpClient client;

    private static String ROOT_API = "/user/admin";

    @LocalServerPort
    private Integer port;

    @BeforeAll
    static void init() {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setup() {
        client = HttpClients.createDefault();
        uriBuilder = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(port).encode();
    }

    @AfterEach
    void release() throws IOException {
        client.close();
    }

    @Test
    @Rollback
    void Welcome() throws IOException {
        var api = uriBuilder
                .path(ROOT_API)
                .toUriString();
        var getRequest = new HttpGet(api);
        var getResponse = client.execute(getRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_OK);
    }

    private ResourceDTO resourceDTO = new ResourceDTO("YOU AS NEW USE ONLY CAN READ IT");

    private CustomerDTO customerDTO = new CustomerDTO(
            "CUSTOMER4USERNAME",
            "CUSTOMER4PASSWORD",
            "CUSTOMER4USERNAME@gmail.com",
            resourceDTO
    );

    @Test
    @Rollback
    void putCustomer() throws IOException {
        var api = uriBuilder
                .path(ROOT_API + "/pc")
                .toUriString();

        var putRequest = new HttpPut(api);

        var jackson = objectMapper.writeValueAsString(customerDTO);
        var reqeustEntity = new StringEntity(jackson, ContentType.APPLICATION_JSON);

        putRequest.setEntity(reqeustEntity);

        var putResponse = client.execute(putRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(putResponse).isEqualTo(HttpStatus.SC_OK);

    }

    private String username = "CUSTOMER1USERNAME";

    @Test
    @Rollback
    void deleteCustomer_WillDelete() throws Exception {
        var api = uriBuilder
                .path(ROOT_API + "/dc")
                .queryParam("username", username)
                .toUriString();

        var deleteRequest = new HttpDelete(api);
        var deleteResponse = client.execute(deleteRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(deleteResponse).isEqualTo(HttpStatus.SC_OK);
    }

    private String fakeUsername = "CUSTOMER11USERNAME";

    @Test
    @Rollback
    void deleteCustomer_FakeUsername_ThrowException() throws Exception {
        var api = uriBuilder
                .path(ROOT_API + "/dc")
                .queryParam("username", fakeUsername)
                .toUriString();

        var deleteRequest = new HttpDelete(api);
        var deleteResponse = client.execute(deleteRequest).getStatusLine().getStatusCode();
        Assertions.assertThat(deleteResponse).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }



}