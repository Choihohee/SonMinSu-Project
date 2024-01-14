package com.sonminsu.sms.repository;

import com.sonminsu.sms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findBySubjectLike(String subject);
    Page<Post> findAll(Pageable pageable);
}
