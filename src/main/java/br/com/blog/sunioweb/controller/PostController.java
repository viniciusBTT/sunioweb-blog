package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.model.Post;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.service.PostService;
import br.com.blog.sunioweb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String posts(Model model, Post post){
        model.addAttribute("posts", postService.findAll());
        return "/post/posts";
    }

    @GetMapping(value = {"/save/{id}","/save"})
    public  String returnUserForm(@PathVariable(required = false) Integer id,
                                  Model model,
                                  Post post){
        if(id != null)
            post = postService.findById(id);

        model.addAttribute("post",post);
        model.addAttribute("subjects", subjectService.findAll());
        return "post/form";
    }

    @PostMapping
    public String save(@ModelAttribute Post post,RedirectAttributes ra ){
        try{
            Date currentDate = new Date();
            if (post.getId() == null){
                post.setPublication(currentDate);
                post.setLastUpdate(currentDate);
                ra.addAttribute("success","Sucesso ao cadastrar a postagem");
            }
            else
            {
                post.setLastUpdate(currentDate);
                ra.addAttribute("success","Sucesso ao atualizar a postagem");
            }
            postService.save(post);
            return "redirect:/posts";

        }catch (Exception e){
            System.out.println(e.getMessage());
            ra.addAttribute("error","Erro ao cadastrar a postagem");
            return "redirect:/posts";
        }

    }
}
