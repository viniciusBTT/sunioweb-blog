package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public String posts(Model model){
        model.addAttribute("posts", postService.findAll());
        return "/post/posts";
    }
}
