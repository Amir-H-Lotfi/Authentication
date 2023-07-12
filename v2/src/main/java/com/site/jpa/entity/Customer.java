package com.site.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "Customers")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    private Resource resource;

    @OneToOne(cascade = CascadeType.ALL)
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}
