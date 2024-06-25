package com.example.blogmanagement.controller;

import com.example.blogmanagement.entity.Comments;
import com.example.blogmanagement.service.CommentsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {
    private CommentsInterface commentsservice;
    public CommentsController(CommentsInterface commentsservice) {
        this.commentsservice = commentsservice;
    }
    @PostMapping(value = "/{post_id}")
    public ResponseEntity<Comments> CreateComments(@PathVariable("post_id") int post_id, @RequestBody Comments comments) {
        Comments savedcomment= commentsservice.createComments(comments, post_id);
        return new ResponseEntity<>(savedcomment, HttpStatus.CREATED);
    }
}
