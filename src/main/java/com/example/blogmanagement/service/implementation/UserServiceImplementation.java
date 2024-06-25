package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.entity.Users;
import com.example.blogmanagement.exception.ResourceNotFoundException;
import com.example.blogmanagement.repository.UserRepository;
import com.example.blogmanagement.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserInterface {
    private UserRepository userrepository;
    @Autowired
    public UserServiceImplementation(UserRepository userrepository) {
        this.userrepository = userrepository;
    }
    @Override
    public Users createUser(Users users) {
        Users saved_user=userrepository.save(users);
        return saved_user;
    }

    @Override
    public Users getUser(int userid) {
        Users user=userrepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("The user does not exist for the given id:"+userid));
        return user;

    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users=userrepository.findAll();
        return users.stream().collect(Collectors.toList());
    }

    public Optional<Users> authenticate(String username, String password) {
        return userrepository.findByUsernameAndPassword(username, password);
    }

}
