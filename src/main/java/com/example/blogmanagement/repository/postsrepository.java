package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.posts;
import com.example.blogmanagement.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface postsrepository extends JpaRepository<posts,Integer> {
    List<posts> findByusers(users users);
}
