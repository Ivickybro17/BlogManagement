package com.example.blogmanagement.controller;

import com.example.blogmanagement.JwtUtil;
import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.entity.Users;
import com.example.blogmanagement.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    private UserInterface userservice;

    public UserController(UserInterface userservice) {
        this.userservice = userservice;
    }

    @PostMapping
    public ResponseEntity<Users> addUser(@RequestBody Users users) {
        Users saved_user=userservice.createUser(users);
        return new ResponseEntity<>(saved_user, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") int userid) {
        Users saved_user=userservice.getUser(userid);
        return new ResponseEntity<>(saved_user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users=userservice.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginrequestdto) {
        Optional<Users> response_user=userservice.authenticate(loginrequestdto.getUsername(), loginrequestdto.getPassword());
        if(response_user.isPresent()){
            return ResponseEntity.ok(jwtUtil.generateToken(loginrequestdto.getUsername(),loginrequestdto.getPassword()));

        }else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
        }
    }
}
