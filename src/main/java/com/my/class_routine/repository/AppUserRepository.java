package com.my.class_routine.repository;

import com.my.class_routine.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsernameIgnoreCase(String username);
    List<AppUser> findByActive(boolean active);
    List<AppUser> findByEmployeeCodeAndActive(String code, boolean active);
}
