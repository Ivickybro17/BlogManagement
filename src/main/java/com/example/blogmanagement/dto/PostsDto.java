package com.example.blogmanagement.dto;

import com.example.blogmanagement.entity.comments;
import com.example.blogmanagement.entity.users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsDto {
    private int id;
    private String title;
    private int likes;
    private String content;
    private String status;
    private LocalDateTime created_at;
    private List<comments> comments;
    private users users;

}
