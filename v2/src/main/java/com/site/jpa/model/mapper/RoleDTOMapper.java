package com.site.jpa.model.mapper;

import com.site.jpa.entity.Role;
import com.site.jpa.model.RoleDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDTOMapper {

    Role from(RoleDTO roleDTO);

    RoleDTO from(Role role);
}
