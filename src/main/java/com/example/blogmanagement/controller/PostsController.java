package com.example.blogmanagement.controller;

import com.example.blogmanagement.JwtUtil;
import com.example.blogmanagement.dto.LoginRequestDto;
import com.example.blogmanagement.entity.Posts;
import com.example.blogmanagement.entity.Users;
import com.example.blogmanagement.repository.UserRepository;
import com.example.blogmanagement.service.PostInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts/")
public class PostsController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private PostInterface postservice;

    public PostsController(PostInterface postservice) {
        this.postservice = postservice;
    }

    @PostMapping("/users")
    public ResponseEntity<Posts> createPost(@RequestBody Posts posts, HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        String username = null;
        String password= null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            password = jwtUtil.extractPassword(jwt);
        }

        Optional<Users> optionalUsers = userrepository.findByUsernameAndPassword(username,password);
        Users user = optionalUsers.get();
        int user_id=user.getId();
        Posts saved_post = postservice.createPost(posts, user_id);
        return new ResponseEntity<>(saved_post, HttpStatus.CREATED);
    }

    @PostMapping("/likes/{post_id}")
    public ResponseEntity<Posts> updateLikes(@PathVariable("post_id") Integer post_id) {
        Posts saved_post = postservice.updateLikes(post_id);
        return new ResponseEntity<>(saved_post, HttpStatus.OK);
    }

    @PostMapping(value = "getdetails")
    public ResponseEntity<List<Posts>> getAllPosts(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        String username = null;
        String password= null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
            password = jwtUtil.extractPassword(jwt);
        }

        LoginRequestDto loginRequestDto = new LoginRequestDto(username, password);
        List<Posts> user_posts = postservice.getAllPostsByUsername(loginRequestDto);
        return new ResponseEntity<>(user_posts.stream()
                .map(posts -> {
                    Posts mapped_post = new Posts();
                    mapped_post.setId(posts.getId());
                    mapped_post.setTitle(posts.getTitle());
                    mapped_post.setLikes(posts.getLikes());
                    mapped_post.setUsers(posts.getUsers());
                    mapped_post.setComments(posts.getComments());
                    mapped_post.setContent(posts.getContent());
                    mapped_post.setStatus(posts.getStatus());
                    mapped_post.setCreated_at(posts.getCreated_at());
                    return mapped_post;
                })
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
