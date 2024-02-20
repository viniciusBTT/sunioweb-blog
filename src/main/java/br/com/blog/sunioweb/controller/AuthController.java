package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String auth()
    {
        try {
            System.out.println("entrou");
//            Role role = new Role("ROLE_ADMIN");
//            User user = new User("vini","123",role);
//            //user = userService.save(user);
//            System.out.println(user.toString());
        }catch (Exception e){
            System.out.println(e);
        }

        return "auth/login";
    }

}
