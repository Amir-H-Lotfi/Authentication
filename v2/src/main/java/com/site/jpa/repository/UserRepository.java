package com.site.jpa.repository;

import com.site.jpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import jakarta.validation.constraints.NotNull;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Integer> {


    Optional<User> findUserByUsername(@NotNull String username) throws IllegalArgumentException;

    Long deleteByUsername(@NotNull String username);
}
