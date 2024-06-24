package com.example.blogmanagement.service;

import com.example.blogmanagement.dto.CommentsDto;

public interface commentsinterface {
    CommentsDto createComments(CommentsDto commentsDto, Integer postsid);
}
