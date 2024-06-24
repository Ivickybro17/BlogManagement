package com.example.blogmanagement.mapper;

import com.example.blogmanagement.dto.PostsDto;
import com.example.blogmanagement.entity.posts;

public class postsmapper {
    public static posts maptoposts(PostsDto postdto){
        return new posts(
                postdto.getId(),
                postdto.getTitle(),
                postdto.getLikes(),
                postdto.getUsers(),
                postdto.getComments(),
                postdto.getContent(),
                postdto.getStatus(),
                postdto.getCreated_at()
        );
    }
    public static PostsDto maptopostsDto(posts posts){
        return new PostsDto(
                posts.getId(),
                posts.getTitle(),
                posts.getLikes(),
                posts.getContent(),
                posts.getStatus(),
                posts.getCreated_at(),
                posts.getComments(),
                posts.getUsers()
        );
    }
}
