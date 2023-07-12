package com.site.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
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
@Transactional
public class PremiumUserControllerIntegrationTest {

    private static ObjectMapper objectMapper;

    private static UriComponentsBuilder apiBuilder;
    private static CloseableHttpClient client;

    private static final String ROOT_API = "/user/premium";

    @LocalServerPort
    private Integer port;

    @BeforeAll
    static void initialized() {
        objectMapper = new ObjectMapper();
    }

    @BeforeEach
    void setup() {
        client = HttpClients.createDefault();
        apiBuilder = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(port).encode();
    }

    @AfterEach
    void release() throws IOException {
        client.close();
    }

    @Test
    void Welcome() throws IOException {
        var api = apiBuilder
                .path(ROOT_API)
                .toUriString();
        var getRequest = new HttpGet(api);
        var getResponse = client.execute(getRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_OK);
    }

    private String realUsername = "CUSTOMER3USERNAME";
    private String fakeUsername = "CUSTOMER33USERNAME";

    @Test
    @Rollback
    void GetMeResource_WithRealUsername() throws IOException {
        var api = apiBuilder
                .path(ROOT_API + "/gmr")
                .queryParam("username", realUsername)
                .toUriString();
        var getRequest = new HttpGet(api);
        var getResponse = client.execute(getRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    @Rollback
    void GetMeResource_WithFakeUsername_ThrowException_ReturnBadRequest() throws IOException {
        var api = apiBuilder
                .path(ROOT_API + "/gmr")
                .queryParam("username", fakeUsername)
                .toUriString();
        var getRequest = new HttpGet(api);
        var getResponse = client.execute(getRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Rollback
    void PutMeResource_WithRealUsername() throws IOException {

        var api = apiBuilder
                .path(ROOT_API + "/pmr")
                .queryParam("username", realUsername)
                .toUriString();

        var entity = new StringEntity(objectMapper.writeValueAsString(new ResourceDTO("Message for write")), ContentType.APPLICATION_JSON);
        var putRequest = new HttpPut(api);
        putRequest.setEntity(entity);
        var putResponse = client.execute(putRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(putResponse).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    @Rollback
    void PutMeResource_WithFakeUsername_ThrowException_ReturnBadRequest() throws IOException {
        var api = apiBuilder
                .path(ROOT_API + "/pmr")
                .queryParam("username", "CUSTOMER11USERNAME")
                .toUriString();
        var entity = new StringEntity(objectMapper.writeValueAsString(new ResourceDTO("Message for write,i got error!")), ContentType.APPLICATION_JSON);
        var putRequest = new HttpPut(api);
        putRequest.setEntity(entity);
        var putResponse = client.execute(putRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(putResponse).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }


    private String password = "CUSTOMERNEWPASSOWRD";

    @Test
    @Rollback
    void PatchMePassword_WithRealUsername() throws IOException {
        var api = apiBuilder
                .path(ROOT_API + "/gmr")
                .queryParam("username", realUsername)
                .toUriString();
        var jackson = objectMapper.writeValueAsString(new PasswordDTO(password));
        var entity = new StringEntity(jackson, ContentType.APPLICATION_JSON);

        var patchRequest = new HttpPatch(api);
        patchRequest.setEntity(entity);

        var getResponse = client.execute(patchRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    @Rollback
    void PatchMePassword_WithFakeUsername_ThrowException_ReturnBadRequest() throws IOException {

        var api = apiBuilder
                .path(ROOT_API + "/gmr")
                .queryParam("username", fakeUsername)
                .toUriString();

        var jackson = objectMapper.writeValueAsString(new PasswordDTO(password));
        var entity = new StringEntity(jackson, ContentType.APPLICATION_JSON);

        var patchRequest = new HttpPatch(api);
        patchRequest.setEntity(entity);

        var getResponse = client.execute(patchRequest, httpResponse -> httpResponse.getStatusLine().getStatusCode());
        Assertions.assertThat(getResponse).isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }


}
