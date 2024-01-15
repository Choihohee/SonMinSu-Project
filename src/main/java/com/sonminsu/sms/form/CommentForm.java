package com.sonminsu.sms.form;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentForm {
    @NotEmpty(message = "댓글을 입력하세요.")
    private String comment;
}
