package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.Posts;
import com.example.blogmanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Integer> {
    List<Posts> findByUsers(Users users);
}
