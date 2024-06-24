package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.dto.CommentsDto;
import com.example.blogmanagement.entity.comments;
import com.example.blogmanagement.entity.posts;
import com.example.blogmanagement.mapper.commentsmapper;
import com.example.blogmanagement.repository.commentsrepository;
import com.example.blogmanagement.repository.postsrepository;
import com.example.blogmanagement.service.commentsinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class commentsserviceimplementation implements commentsinterface {
    private commentsrepository commentsRepository;
    @Autowired
    public commentsserviceimplementation(commentsrepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    @Autowired
    private postsrepository postsRepository;

    @Override
    public CommentsDto createComments(CommentsDto commentsDto, Integer postsid) {
        comments comments= commentsmapper.maptocomments(commentsDto);
        Optional<posts> optionalpost = postsRepository.findById(postsid);
        posts post = optionalpost.get();
        comments.setPosts(post);
        CommentsDto savedcomment=commentsmapper.maptocommentsDto(commentsRepository.save(comments));
        return savedcomment;
    }
}
