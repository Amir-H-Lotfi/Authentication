package com.site.jpa.model.mapper;

import com.site.jpa.entity.Authority;
import com.site.jpa.model.AuthorityDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityDTOMapper {
    AuthorityDTO from(Authority authority);

    Authority from(AuthorityDTO authorityDTO);
}
