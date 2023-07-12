package com.site.jpa.service;

import com.site.jpa.exception.applicationspecifiedexception.CustomerCreationException;
import com.site.jpa.exception.applicationspecifiedexception.CustomerRemovalException;
import com.site.jpa.exception.applicationspecifiedexception.PasswordModificationException;
import com.site.jpa.model.UserDTO;
import com.site.jpa.model.PasswordDTO;

public interface AdminUserService {

    default String welcome() {
        return "Welcome";
    }

    Boolean putMeCustomer(UserDTO userDTO) throws CustomerCreationException;

    Boolean deleteMeCustomer(String username) throws CustomerRemovalException;

    Boolean patchMePassword(String username, PasswordDTO passwordDTO) throws PasswordModificationException;
}
