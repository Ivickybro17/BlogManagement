package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.Follows;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowsRepository extends JpaRepository<Follows,Integer> {
}
