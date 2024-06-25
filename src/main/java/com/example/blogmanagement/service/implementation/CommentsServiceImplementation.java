package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.entity.Comments;
import com.example.blogmanagement.entity.Posts;
import com.example.blogmanagement.repository.CommentsRepository;
import com.example.blogmanagement.repository.PostsRepository;
import com.example.blogmanagement.service.CommentsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsServiceImplementation implements CommentsInterface {
    private CommentsRepository commentsRepository;
    @Autowired
    public CommentsServiceImplementation(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public Comments createComments(Comments comments, Integer postsid) {
        Optional<Posts> optionalpost = postsRepository.findById(postsid);
        Posts post = optionalpost.get();
        comments.setPosts(post);
        Comments savedcomment=commentsRepository.save(comments);
        return savedcomment;
    }
}
