package com.sonminsu.sms.service;

import com.sonminsu.sms.DataNotFoundException;
import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;


    public List<Post> getList() {
        return this.postRepository.findAll();
    }


    public Post getPost(Integer postId) {
        Optional<Post> post = this.postRepository.findById(postId);
        if (post.isPresent()) {
            return post.get();
        } else {
            throw new DataNotFoundException("post not found");
        }
    }

    //저장
        public void create(String subject){ //, String imagePath
        Post post = new Post();
        post.setSubject(subject);
        post.setCreateDate(LocalDateTime.now());
        this.postRepository.save(post);
    }

}
