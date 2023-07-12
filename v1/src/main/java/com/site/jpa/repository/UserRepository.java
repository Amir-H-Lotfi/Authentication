package com.site.jpa.repository;

import com.site.jpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import jakarta.validation.constraints.NotNull;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, Integer> {
    Optional<T> findByUsername(@NotNull String username) throws Exception;

    Long deleteByUsername(@NotNull String username) throws Exception;
}
