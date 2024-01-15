package com.sonminsu.sms.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostForm {
    @NotEmpty(message="제목을 입력하세요.")
    @Size(max=30)
    private String subject;

    /*
    @NotEmpty(message="이미지를 업로드하세요.")
    @Size(max=255)
    private String imagePath;
    */
}
