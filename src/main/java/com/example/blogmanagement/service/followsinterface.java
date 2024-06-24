package com.example.blogmanagement.service;

import com.example.blogmanagement.dto.FollowsDto;

public interface followsinterface {
    FollowsDto createFollow(FollowsDto followsDto, int user_id);
}
