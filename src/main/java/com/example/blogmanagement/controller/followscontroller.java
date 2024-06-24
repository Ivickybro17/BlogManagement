package com.example.blogmanagement.controller;

import com.example.blogmanagement.dto.FollowsDto;
import com.example.blogmanagement.service.followsinterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/follows/")
public class followscontroller {
    private followsinterface followsservice;


    @PostMapping(value = "/users/{user_id}")
    public ResponseEntity<FollowsDto> createFollows(FollowsDto followsDto,@PathVariable("user_id") int user_id){
        FollowsDto saved_follows= followsservice.createFollow(followsDto,user_id);
        return new ResponseEntity<>(saved_follows, HttpStatus.CREATED);
    }

}
