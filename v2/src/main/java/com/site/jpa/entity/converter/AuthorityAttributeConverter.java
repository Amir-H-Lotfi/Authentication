package com.site.jpa.entity.converter;

import com.site.jpa.entity.Authority;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AuthorityAttributeConverter implements AttributeConverter<Authority.AuthorityType, String> {
    @Override
    public String convertToDatabaseColumn(Authority.AuthorityType authorityType) {
        return switch (authorityType) {

            case AUTHORITY$READ -> Authority.AuthorityType.AUTHORITY$READ.value;
            case AUTHORITY$WRITE -> Authority.AuthorityType.AUTHORITY$WRITE.value;
            case AUTHORITY$CREATE -> Authority.AuthorityType.AUTHORITY$CREATE.value;
            case AUTHORITY$REMOVE -> Authority.AuthorityType.AUTHORITY$REMOVE.value;
        };
    }

    @Override
    public Authority.AuthorityType convertToEntityAttribute(String s) {
        return switch (s) {
            case "authority.read" -> Authority.AuthorityType.AUTHORITY$READ;
            case "authority.write" -> Authority.AuthorityType.AUTHORITY$WRITE;
            case "authority.create" -> Authority.AuthorityType.AUTHORITY$CREATE;
            case "authority.remove" -> Authority.AuthorityType.AUTHORITY$REMOVE;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
