package com.sonminsu.sms.controller;

import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/post/list")
    public String postList(Model model){
        List<Post> postList = this.postService.getList();

        return "post_list";
    }
}
