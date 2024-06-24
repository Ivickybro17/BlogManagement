package com.example.blogmanagement.dto;

import com.example.blogmanagement.entity.users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowsDto {
    private int id;
    private users users;
    private int follower;
    private int following;
}
