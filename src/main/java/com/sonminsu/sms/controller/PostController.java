package com.sonminsu.sms.controller;

import org.springframework.web.multipart.MultipartFile;
import com.sonminsu.sms.form.PostForm;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.sonminsu.sms.form.CommentForm;
import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.repository.PostRepository;
import com.sonminsu.sms.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.List;

@RequestMapping("/post")
@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String postList(Model model){
        List<Post> postList = this.postService.getList();
        model.addAttribute("postList", postList);

        return "post_list";
    }
    @GetMapping("/detail/{postId}")
    public String detail(Model model, @PathVariable("postId") Integer postId, CommentForm commentForm) {
        Post post = this.postService.getPost(postId);
        model.addAttribute("post", post);
        return "post_detail";
    }

    @GetMapping("/create")
    public String postCreate(PostForm postForm) {
        return "post_form";
    }

    @PostMapping("/create")
    public String postCreate(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "post_form";
        }
        this.postService.create(postForm.getSubject());   //질문 저장
        return "redirect:/post/list"; // 질문 저장후 질문목록으로 이동
    }
}
