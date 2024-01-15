package com.sonminsu.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/sonminsu")
    @ResponseBody
    public String index(){
        return "안녕하세요 SonMinSu 홈페이지입니다.";
    }

    @GetMapping("/") //홈페이지로 이동(localhost 호출 시 바로 이 페이지로 이동)
    public String root(){
        return "redirect:/post/list";
    }
}
