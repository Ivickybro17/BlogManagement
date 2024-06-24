package com.example.blogmanagement.mapper;

import com.example.blogmanagement.dto.UsersDto;
import com.example.blogmanagement.entity.users;
import java.time.LocalDateTime;

public class usermapper {
    public static users maptousers(UsersDto usersdto){
        return new users(
                usersdto.getId(),
                usersdto.getUsername(),
                usersdto.getPassword(),
                usersdto.getCreated_at(),
                usersdto.getPosts(),
                usersdto.getFollows()
        );
    }

    public static UsersDto maptousersDto(users user){
        return new UsersDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getCreated_at(),
                user.getPosts(),
                user.getFollows()
        );
    }
}
