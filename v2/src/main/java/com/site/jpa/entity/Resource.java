package com.site.jpa.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "resources")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resource {

    private Integer id;
    private String resource;

    public Resource(String resource) {
        this.resource = resource;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource resource1)) return false;
        return Objects.equals(resource, resource1.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource);
    }
}
