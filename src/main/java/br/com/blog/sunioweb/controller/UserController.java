package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.dto.UserPostDTO;
import br.com.blog.sunioweb.model.Role;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.http.HttpClient;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model, User user){
        model.addAttribute("users", userService.findAll());
        return "/user/users";
    }

    @GetMapping(value = {"/save/{username}","/save"})
    public  String returnUserForm(@PathVariable(required = false) String username,
                                  Model model,
                                  User user){
        if(username != null)
            user = userService.findById(username);

        model.addAttribute("user",user);
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserPostDTO dto, RedirectAttributes ra){
        try {
            var user = userService.verifyByUser(dto.username());
            if (user == null){
                userService.save(dto);
                ra.addFlashAttribute("success","Usuário cadastrado com sucesso");
            }
            else {
                ra.addFlashAttribute("error","Nome de usuário já cadastrado");
            }
          }catch (Exception e){
            System.out.println(e.getMessage());
            ra.addFlashAttribute("error","Erro ao cadastrar o usuário");

        }

        return "redirect:/users";
    }
}
