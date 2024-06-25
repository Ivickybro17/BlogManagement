package com.example.blogmanagement.service.implementation;

import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.entity.Posts;
import com.example.blogmanagement.entity.Users;
import com.example.blogmanagement.repository.PostsRepository;
import com.example.blogmanagement.service.PostInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blogmanagement.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImplementation implements PostInterface {

    private PostsRepository postsrepository;
    @Autowired
    public PostsServiceImplementation(PostsRepository postsrepository) {
        this.postsrepository = postsrepository;
    }

    @Autowired
    private UserRepository userrepository;

    @Override
    public Posts createPost(Posts posts, Integer userId) {
        Optional<Users> optinaluser= userrepository.findById(userId);
        Users user=optinaluser.get();
        posts.setUsers(user);
        Posts saved_post=postsrepository.save(posts);
        return saved_post;
    }

    @Override
    public Posts updateLikes(Integer postid) {

        Optional<Posts> optionalpost=postsrepository.findById(postid);
        Posts post=optionalpost.get();
        post.incrementlikes();
        Posts saved_post=postsrepository.save(post);
        return saved_post;

    }

    @Override
    public List<Posts> getAllPostsByUsername(LoginRequestDto loginRequestDto) {
        Optional<Users> optinaluser=userrepository.findByUsernameAndPassword(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Users users=optinaluser.get();
        return postsrepository.findByUsers(users);
    }
}
