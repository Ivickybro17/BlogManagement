package com.example.blogmanagement.mapper;

import com.example.blogmanagement.dto.CommentsDto;
import com.example.blogmanagement.entity.comments;

public class commentsmapper {
    public static comments maptocomments(CommentsDto commentsDto){
        return new comments(
                commentsDto.getId(),
                commentsDto.getContent(),
                commentsDto.getPosts()
        );
    }
    public static CommentsDto maptocommentsDto(comments comments){
        return new CommentsDto(
                comments.getId(),
                comments.getComment(),
                comments.getPosts()
        );
    }
}
