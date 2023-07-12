package com.site.jpa.entity.converter;

import com.site.jpa.entity.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RoleAttributeConverter implements AttributeConverter<Role.RoleType, String> {
    @Override
    public String convertToDatabaseColumn(Role.RoleType roleType) {
        return switch (roleType) {
            case USER$DEFAULT -> Role.RoleType.USER$DEFAULT.value;
            case USER$PREMIUM -> Role.RoleType.USER$PREMIUM.value;
            case USER$ADMIN -> Role.RoleType.USER$ADMIN.value;
        };
    }

    @Override
    public Role.RoleType convertToEntityAttribute(String s) {
        return switch (s) {
            case "USER_DEFAULT" -> Role.RoleType.USER$DEFAULT;
            case "USER_PREMIUM" -> Role.RoleType.USER$PREMIUM;
            case "USER_ADMIN" -> Role.RoleType.USER$ADMIN;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
