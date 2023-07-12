package com.site.jpa.service.abstraction.interfaces;

import com.site.jpa.model.ResourceDTO;
import jakarta.validation.constraints.NotNull;

import org.springframework.transaction.annotation.Transactional;

public interface PremiumService extends DefaultService {

    @Transactional(rollbackFor = Exception.class)
    Boolean putMeResource(@NotNull String username, @NotNull ResourceDTO resource) throws Exception;
}
