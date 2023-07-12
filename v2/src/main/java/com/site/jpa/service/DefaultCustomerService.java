package com.site.jpa.service;

import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceAccessException;
import com.site.jpa.model.PasswordDTO;

public interface DefaultCustomerService {

    default String welcome() {
        return "Welcome";
    }

    String getMeResource(String username) throws ResourceAccessException;

    Boolean patchMePassword(String username, PasswordDTO passwordDTO) throws PasswordModificationException;
}
