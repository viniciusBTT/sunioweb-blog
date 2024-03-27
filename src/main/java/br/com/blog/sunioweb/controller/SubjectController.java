package br.com.blog.sunioweb.controller;

import br.com.blog.sunioweb.model.Post;
import br.com.blog.sunioweb.model.Subject;
import br.com.blog.sunioweb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping
    public  String subjects(Model model){
        model.addAttribute("subjects", service.findAll());
        return "/subject/subjects";
    }

    @GetMapping({"/save","/save/{id}"})
    public String saveForm(@PathVariable(required = false) Integer id,
                           Model model,
                           Subject subject){
        if(id != null)
            subject = service.findById(id);

        model.addAttribute("subject",subject);
        return "/subject/form";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subject subject, RedirectAttributes ra){
        try {
            if(service.verifyByName(subject.getName()) == null)            {
                service.save(subject);
                ra.addFlashAttribute("success", "Assunto cadastrado com sucesso!");
            }
            else{
                ra.addAttribute("error","Assunto já cadastrado");
            }
        }catch (Exception e){
            ra.addFlashAttribute("error","Erro ao cadastrar o assunto");
            System.out.println(e.getMessage());
        }
        return "redirect:/subjects";
    }

}
