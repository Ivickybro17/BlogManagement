package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsernameAndPassword(String username, String password);
}
