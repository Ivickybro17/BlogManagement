package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Comments;

public interface CommentsInterface {
    Comments createComments(Comments comments, Integer postsid);
}
