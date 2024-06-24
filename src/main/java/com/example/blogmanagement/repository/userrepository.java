package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface userrepository extends JpaRepository<users,Integer> {
    Optional<users> findByUsernameAndPassword(String username, String password);
}
