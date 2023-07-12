package com.demoapplication.springbootrestfulwebservices.repositories;

import com.demoapplication.springbootrestfulwebservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
