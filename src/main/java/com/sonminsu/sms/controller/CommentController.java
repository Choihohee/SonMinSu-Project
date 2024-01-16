package com.sonminsu.sms.controller;

import com.sonminsu.sms.form.CommentForm;
import com.sonminsu.sms.model.Post;
import com.sonminsu.sms.service.CommentService;
import com.sonminsu.sms.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {

    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/create/{commentId}")
    public String createComment(Model model, @PathVariable("commentId") Integer commentId, @Valid CommentForm commentForm, BindingResult bindingResult) {
        Post post = this.postService.getPost(commentId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("post", post);
            return "post_detail";
        }
        this.commentService.createComment(post, commentForm.getComment());
        return String.format("redirect:/post/detail/%s", commentId);
    }
}