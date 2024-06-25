package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Follows;

public interface FollowsInterface {
    Follows createFollow(Follows follows, int user_id);
}
