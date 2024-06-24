package com.example.blogmanagement.service;

import com.example.blogmanagement.dto.UsersDto;
import com.example.blogmanagement.entity.users;

import java.util.List;
import java.util.Optional;

public interface userinterface {
    UsersDto createuser(UsersDto usersDto);
    UsersDto getUser(int userid);
    List<UsersDto> getAllUsers();
    Optional<users> authenticate(String username, String password);
}
