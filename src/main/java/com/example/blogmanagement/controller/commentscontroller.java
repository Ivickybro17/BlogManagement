package com.example.blogmanagement.controller;

import com.example.blogmanagement.dto.CommentsDto;
import com.example.blogmanagement.entity.comments;
import com.example.blogmanagement.mapper.commentsmapper;
import com.example.blogmanagement.service.commentsinterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comments")
public class commentscontroller {
    private commentsinterface commentsservice;
    public commentscontroller(commentsinterface commentsservice) {
        this.commentsservice = commentsservice;
    }
    @PostMapping(value = "/{post_id}")
    public ResponseEntity<CommentsDto> CreateComments(@PathVariable("post_id") int post_id, @RequestBody CommentsDto commentsdto) {
        CommentsDto savedcomment= commentsservice.createComments(commentsdto, post_id);
        return new ResponseEntity<>(savedcomment, HttpStatus.CREATED);
    }
}
