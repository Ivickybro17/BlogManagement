package com.example.blogmanagement.controller;

import com.example.blogmanagement.entity.Follows;
import com.example.blogmanagement.service.FollowsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/follows/")
public class FollowsController {
    private FollowsInterface followsservice;


    @PostMapping(value = "/users/{user_id}")
    public ResponseEntity<Follows> createFollows(Follows follows, @PathVariable("user_id") int user_id){
        Follows saved_follows= followsservice.createFollow(follows,user_id);
        return new ResponseEntity<>(saved_follows, HttpStatus.CREATED);
    }

}
