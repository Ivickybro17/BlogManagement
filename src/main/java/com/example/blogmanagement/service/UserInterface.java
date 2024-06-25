package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserInterface {
    Users createUser(Users users);
    Users getUser(int userid);
    List<Users> getAllUsers();
    Optional<Users> authenticate(String username, String password);
}
