package com.site.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer extends User {

    private Resource resource;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    // assume that customer is just a raw type, application wanna persist in database
    public void addResource(@NotNull Resource resource) {
        this.resource = resource;
        resource.setCustomer(this);
    }

}
