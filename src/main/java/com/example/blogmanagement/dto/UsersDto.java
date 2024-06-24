package com.example.blogmanagement.dto;

import com.example.blogmanagement.entity.posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.blogmanagement.entity.follows;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
    private int id;
    private String username;
    private String password;
    private LocalDateTime created_at;
    private List<posts> posts;
    private List<follows> follows;
}
