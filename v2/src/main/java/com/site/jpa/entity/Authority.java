package com.site.jpa.entity;

import com.site.jpa.entity.converter.AuthorityAttributeConverter;

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

@Entity(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {

    public enum AuthorityType {
        AUTHORITY$READ("authority.read"),
        AUTHORITY$WRITE("authority.write"),
        AUTHORITY$CREATE("authority.create"),
        AUTHORITY$REMOVE("authority.remove");
        public final String value;

        AuthorityType(String value) {
            this.value = value;
        }

    }

    private Integer id;
    private AuthorityType authority;

    public Authority(String authority) {

        switch (authority) {
            case "authority.read" -> this.authority = AuthorityType.AUTHORITY$READ;
            case "authority.write" -> this.authority = AuthorityType.AUTHORITY$WRITE;
            case "authority.create" -> this.authority = AuthorityType.AUTHORITY$CREATE;
            case "authority.remove" -> this.authority = AuthorityType.AUTHORITY$REMOVE;

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
    @Convert(converter = AuthorityAttributeConverter.class)
    public AuthorityType getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority authority1)) return false;
        return authority == authority1.authority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }
}
