package com.ing06164.springboot.web;

import com.ing06164.springboot.config.auth.LoginUser;
import com.ing06164.springboot.config.auth.dto.SessionUser;
import com.ing06164.springboot.service.posts.PostsService;
import com.ing06164.springboot.web.Dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){      // 컨트롤러에서 문자열을 반환할 때, 머스테치 스타터가 파일 경로와 확장자를 자동으로 지정함
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null)
            model.addAttribute("userName", user.getName());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
