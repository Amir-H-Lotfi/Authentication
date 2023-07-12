package com.site.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResourceDTO implements Serializable {

    private String resource;

    public ResourceDTO() {

    }

    public ResourceDTO(String resource) {
        this.resource = resource;
    }

    @JsonProperty
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
