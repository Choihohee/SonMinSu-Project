package com.sonminsu.sms.repository;

import com.sonminsu.sms.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
