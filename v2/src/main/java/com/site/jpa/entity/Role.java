package com.site.jpa.entity;

import com.site.jpa.entity.converter.RoleAttributeConverter;
import com.site.jpa.model.RoleDTO;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    public enum RoleType {
        USER$DEFAULT("USER_DEFAULT"),
        USER$PREMIUM("USER_PREMIUM"),
        USER$ADMIN("USER_ADMIN");

        public final String value;

        RoleType(String value) {
            this.value = value;
        }
    }

    private Integer id;
    private RoleType role;

    public Role(String role) {
        switch (role) {
            case "USER_DEFAULT" -> this.role = RoleType.USER$DEFAULT;
            case "USER_PREMIUM" -> this.role = RoleType.USER$PREMIUM;
            case "USER_ADMIN" -> this.role = RoleType.USER$ADMIN;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(unique = true)
    @Convert(converter = RoleAttributeConverter.class)
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role1)) return false;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
