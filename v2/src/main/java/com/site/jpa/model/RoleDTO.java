package com.site.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO implements Serializable {
    private String role;

    @JsonProperty
    @NotBlank(message = "Define Roles")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
