package com.example.blogmanagement.controller;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.dto.PostsDto;
import com.example.blogmanagement.entity.posts;
import com.example.blogmanagement.service.postinterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts/")
public class postscontroller {
    private postinterface postservice;

    public postscontroller(postinterface postservice) {
        this.postservice = postservice;
    }

    @PostMapping("/users/{user_id}")
    public ResponseEntity<PostsDto> createPost(@RequestBody PostsDto postsDto, @PathVariable("user_id") Integer user_id) {
        PostsDto saved_post=postservice.createPost(postsDto,user_id);
        return new ResponseEntity<>(saved_post, HttpStatus.CREATED);
    }

    @PostMapping("/likes/{post_id}")
    public ResponseEntity<PostsDto> updatelikes(@PathVariable("post_id") Integer post_id){
        PostsDto saved_post=postservice.updatelikes(post_id);
        return new ResponseEntity<>(saved_post, HttpStatus.OK);
    }

    @GetMapping(value = "/getdetails/")
    public ResponseEntity<List<posts>> getAllPosts(@RequestBody LoginRequestDto loginRequestDto){
        List<posts> user_posts=postservice.getallpostsbyusername(loginRequestDto);
        return new ResponseEntity<>(user_posts,HttpStatus.OK);
    }

}
