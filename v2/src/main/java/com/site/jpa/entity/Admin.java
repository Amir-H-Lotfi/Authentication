package com.site.jpa.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "admins")
@AllArgsConstructor
@SuperBuilder
public class Admin extends User {
}
