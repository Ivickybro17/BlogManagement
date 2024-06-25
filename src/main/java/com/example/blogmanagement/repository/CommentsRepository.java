package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {
}