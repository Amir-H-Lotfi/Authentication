package com.site.jpa.controller;

import com.site.jpa.model.PasswordDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class DefaultUserControllerIntegrationTest {

    private static UriComponentsBuilder apiBuilder;
    private static RestTemplate client;

    private static final String ROOT_API = "/user/default";


    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        apiBuilder = UriComponentsBuilder.newInstance().scheme("http").host("localhost").port(port).encode();
        client = new RestTemplate();
        client.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }

    @Test
    @Rollback
    void welcome() {
        String api = apiBuilder.path(ROOT_API).toUriString();
        ResponseEntity<String> responseEntity = client.getForEntity(api, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private String realUsername = "CUSTOMER0USERNAME";
    private String fakeUsername = "CUSTOMER00USERNAME";

    @Test
    @Rollback
    void GetMeResource_WithRealUser() {
        var api = apiBuilder.path(ROOT_API + "/gmr")
                .queryParam("username", "{username}").build()
                .expand(realUsername).toUriString();

        ResponseEntity<String> responseEntity = client.getForEntity(api, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    @Rollback
    void GetMeResource_WithFakeUser_ThrowException_ReturnBadRequest() {
        var api = apiBuilder.path(ROOT_API + "/gmr")
                .queryParam("username", "{username}")
                .build().expand(fakeUsername).toUriString();
        Assertions.assertThrows(HttpClientErrorException.class, () -> client.getForEntity(api, String.class));
    }

    private String realUserNewPassword = "CUSTOMER0NEWUSERNAME" ;

    @Test
    @Rollback
    void PatchMePassword_WithRealUser() {

        var api = apiBuilder.path(ROOT_API + "/pmp")
                .queryParam("username", "{username}")
                .build().expand(realUsername).toUriString();

        var body = new PasswordDTO(realUserNewPassword);
        var patchRequestEntity = RequestEntity.patch(api).body(body);

        var patchResponseEntity = client.exchange(api, HttpMethod.PATCH, patchRequestEntity, Boolean.class);
        assertThat(patchResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    private String fakeUserNewPassword  = "CUSTOMER00NEWPASSWORD";

    @Test
    @Rollback
    void PatchMePassword_WithFakeUser_ThrowException_ReturnBadRequest() {
        var api = apiBuilder.path(ROOT_API + "/pmp")
                .queryParam("username", "{username}")
                .build().expand(fakeUsername).toUriString();

        var body = new PasswordDTO(fakeUserNewPassword);
        var patchRequestEntity = RequestEntity.patch(api).body(body);

        assertThrows(HttpClientErrorException.class, () -> client.exchange(api, HttpMethod.PATCH, patchRequestEntity, Boolean.class));
    }

}