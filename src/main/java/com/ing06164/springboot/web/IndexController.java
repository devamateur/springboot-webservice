package com.ing06164.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(){      // 컨트롤러에서 문자열을 반환할 때, 머스테치 스타터가 파일 경로와 확장자를 자동으로 지정함
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
