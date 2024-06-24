package com.example.blogmanagement.mapper;

import com.example.blogmanagement.dto.FollowsDto;
import com.example.blogmanagement.entity.follows;

public class followsmapper {
    public static FollowsDto maptofollowsDto(follows follows){
        return new FollowsDto(
                follows.getId(),
                follows.getUsers(),
                follows.getFollower(),
                follows.getFollowing()
        );
    }
    public static follows maptofollows(FollowsDto followsDto){
        return new follows(
                followsDto.getId(),
                followsDto.getUsers(),
                followsDto.getFollower(),
                followsDto.getFollowing()
        );
    }
}
