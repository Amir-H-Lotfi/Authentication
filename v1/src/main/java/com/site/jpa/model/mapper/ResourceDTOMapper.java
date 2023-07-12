package com.site.jpa.model.mapper;

import com.site.jpa.entity.Resource;
import com.site.jpa.model.ResourceDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResourceDTOMapper {

    Resource from(ResourceDTO resourceDTO);
}
