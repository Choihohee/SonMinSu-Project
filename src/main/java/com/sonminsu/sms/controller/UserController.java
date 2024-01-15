package com.sonminsu.sms.controller;

import com.sonminsu.sms.service.UserService;
import jakarta.validation.Valid;
import com.sonminsu.sms.form.UserCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //회원가입 페이지
    @GetMapping("/signUp")
    public String signIn(UserCreateForm userCreateForm) {
        return "signUp_form";
    }

    @PostMapping("/signUp")
    public String signIn(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signUp_form";
        }

        if (!userCreateForm.getUserPassword1().equals(userCreateForm.getUserPassword2())) {
            bindingResult.rejectValue("userPassword2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signUp_form";
        }

        userService.create(userCreateForm.getUserName(), userCreateForm.getUserId(), userCreateForm.getEmail(), userCreateForm.getUserPassword1());

        return "redirect:/";
    }
}
