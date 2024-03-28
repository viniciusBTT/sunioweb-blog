package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.dto.UserPostDTO;
import br.com.blog.sunioweb.model.Role;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Field;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model){
        model.addAttribute("users", userService.findAll());
        return "/user/users";
    }

    @GetMapping(value = {"/save/{id}","/save"})
    public  String returnUserForm(@PathVariable(required = false) Integer id,
                                  Model model, User user){
        if(id != null)
            user = userService.findById(id);

        model.addAttribute("user",user);
        return "user/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UserPostDTO dto, RedirectAttributes ra){
        try {
            if(dto.id() == null){
                User user = new User(dto.username(), dto.password(), dto.fullName(), new Role(dto.roles()));
                userService.save(user);
                ra.addFlashAttribute("success","Usuário cadastrado com sucesso");
            }
           else{
                User user = userService.findById(dto.id());

                user.setUsername(dto.username());
                user.setFullName(dto.fullName());
                user.getRoles().add(0, new Role(dto.roles()));
                if(!user.getPassword().equals(dto.password()))
                    user.setPassword(new BCryptPasswordEncoder().encode(dto.password()));

                userService.save(user);
                ra.addFlashAttribute("success","Usuário atualizado com sucesso");
           }
          }catch (Exception e){
            System.out.println(e.getMessage());
            ra.addFlashAttribute("error","Erro ao registrar o usuário");
        }
        return "redirect:/users";
    }
}
