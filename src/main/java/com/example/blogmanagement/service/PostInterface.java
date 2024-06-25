package com.example.blogmanagement.service;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.entity.Posts;

import java.util.List;

public interface PostInterface {
    Posts createPost(Posts posts, Integer userid);
    Posts updateLikes(Integer postid);
    List<Posts> getAllPostsByUsername(LoginRequestDto loginRequestDto);
}
