package com.example.blogmanagement.controller;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.dto.UsersDto;
import com.example.blogmanagement.entity.users;
import com.example.blogmanagement.service.userinterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/users")
public class usercontroller {
    private userinterface userservice;

    public usercontroller(userinterface userservice) {
        this.userservice = userservice;
    }

    @PostMapping
    public ResponseEntity<UsersDto> adduser(@RequestBody UsersDto usersdto) {
        UsersDto saved_user=userservice.createuser(usersdto);
        return new ResponseEntity<>(saved_user, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsersDto> getuser(@PathVariable("id") int userid) {
        UsersDto saved_user=userservice.getUser(userid);
        return new ResponseEntity<>(saved_user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsersDto>> getallusers(){
        List<UsersDto> users=userservice.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginrequestdto) {
        Optional<users> response_user=userservice.authenticate(loginrequestdto.getUsername(), loginrequestdto.getPassword());
        if(response_user.isPresent()){
            return  ResponseEntity.ok("Login Successful");
        }else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed");
        }
    }
}
