package com.sonminsu.sms.controller;

import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.service.PostInfoService;
import com.sonminsu.sms.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/postInfo")
@RequiredArgsConstructor
@Controller
public class PostInfoController {

    private final PostService postService;
    private final PostInfoService postInfoService;

    @PostMapping("/create/{postInfoId}")
    public String createPostInfo(Model model, @PathVariable("postInfoId") Integer postInfoId, @RequestParam(value = "brandName") String brandName, @RequestParam(value = "prodectName") String prodectName, @RequestParam(value = "urlLink") String urlLink) {
        Post post = this.postService.getPost(postInfoId);
        this.postInfoService.createPostInfo(post, brandName, prodectName, urlLink);
        return String.format("redirect:/post/detail/%s\", postInfoId");
    }

}
