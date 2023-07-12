package com.site.jpa.service.abstraction.interfaces;

import com.site.jpa.model.PasswordDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.transaction.annotation.Transactional;


public interface DefaultService {
    default String welcome() {
        return String.format("Welcome");
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    String getMeResource(@NotNull String username) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    Boolean patchMePassword(@NotNull String username, @NotNull PasswordDTO password) throws Exception;

}
