package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentsrepository extends JpaRepository<comments,Integer> {
}
