package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.dto.UsersDto;
import com.example.blogmanagement.entity.users;
import com.example.blogmanagement.exception.ResourceNotFoundException;
import com.example.blogmanagement.mapper.usermapper;
import com.example.blogmanagement.repository.userrepository;
import com.example.blogmanagement.service.userinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userserviceimplementation implements userinterface {
    private userrepository userrepository;
    @Autowired
    public userserviceimplementation(userrepository userrepository) {
        this.userrepository = userrepository;
    }
    @Override
    public UsersDto createuser(UsersDto usersDto) {
        users user= usermapper.maptousers(usersDto);
        UsersDto saved_user=usermapper.maptousersDto(userrepository.save(user));
        return saved_user;
    }

    @Override
    public UsersDto getUser(int userid) {
        users user=userrepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("The user does not exist for the given id:"+userid));
        return usermapper.maptousersDto(user);

    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<users> users=userrepository.findAll();
        return users.stream().map((user)->usermapper.maptousersDto(user)).collect(Collectors.toList());
    }

    public Optional<users> authenticate(String username, String password) {
        return userrepository.findByUsernameAndPassword(username, password);
    }

}
