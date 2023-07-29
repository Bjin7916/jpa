package com.jpa.task.repository.post;

import com.jpa.task.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostQueryDSL {
}
