package com.example.blogmanagement.dto;

import com.example.blogmanagement.entity.posts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private int id;
    private String content;
    private posts posts;
}
