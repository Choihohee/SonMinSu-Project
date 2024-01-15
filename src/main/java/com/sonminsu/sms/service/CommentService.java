package com.sonminsu.sms.service;

import com.sonminsu.sms.model.Comment;
import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public void createComment(Post post, String content){
        Comment comment = new Comment();
        comment.setComment(content);
        comment.setCreateDate(LocalDateTime.now());
        comment.setPost(post);
        this.commentRepository.save(comment);
    }
}
