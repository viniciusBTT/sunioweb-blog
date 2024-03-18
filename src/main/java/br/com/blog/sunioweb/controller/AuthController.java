package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String auth(HttpServletRequest request)
    {
        return "/auth/login";
    }

}
