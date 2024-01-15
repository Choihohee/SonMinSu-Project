package com.sonminsu.sms.repository;

import com.sonminsu.sms.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findBySubject(String subject);
    List<Post> findBySubjectLike(String subject);
}
