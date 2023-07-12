package com.site.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PasswordDTO implements Serializable {
    private String password;

    public PasswordDTO() {
    }

    public PasswordDTO(String password) {
        this.password = password;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
