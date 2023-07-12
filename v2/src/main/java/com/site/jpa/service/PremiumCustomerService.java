package com.site.jpa.service;

import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceModificationException;
import com.site.jpa.exception.applicationspecifiedexception.ResourceAccessException;
import com.site.jpa.model.PasswordDTO;
import com.site.jpa.model.ResourceDTO;

public interface PremiumCustomerService {

    default String welcome() {
        return "Welcome";
    }

    String getMeResource(String username) throws ResourceAccessException;
    Boolean putMeResource(String username, ResourceDTO resourceDTO) throws ResourceModificationException;
    Boolean patchMePassword(String username, PasswordDTO passwordDTO) throws PasswordModificationException;
}
