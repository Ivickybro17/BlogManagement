package com.example.blogmanagement.service;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.dto.PostsDto;
import com.example.blogmanagement.entity.posts;

import java.util.List;

public interface postinterface {
    PostsDto createPost(PostsDto postsDto, Integer userid);
    PostsDto updatelikes(Integer postid);
    List<posts> getallpostsbyusername(LoginRequestDto loginRequestDto);

}
