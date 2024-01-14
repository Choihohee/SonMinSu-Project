package com.sonminsu.sms.service;

import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    public List<Post> getList() {
        return this.postRepository.findAll();
    }
}
