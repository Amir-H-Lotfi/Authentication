package com.site.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
public class CustomerDTO implements Serializable {

    private String username;
    private String password;
    private String email;
    private ResourceDTO resource;

    public CustomerDTO() {
    }

    public CustomerDTO(String username, String password, String email, ResourceDTO resource) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.resource = resource;
    }

    @JsonProperty
    @ToString.Include
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    @ToString.Include
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public ResourceDTO getResource() {
        return resource;
    }

    public void setResource(ResourceDTO resource) {
        this.resource = resource;
    }
}
