package br.com.blog.sunioweb.service;

import br.com.blog.sunioweb.model.Subject;
import br.com.blog.sunioweb.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public List<Subject> findAll(){
        return repository.findAll();
    }

    public Subject findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Subject save(Subject subject){
        return repository.save(subject);
    }

    public Subject verifyByName(String name){
        return repository.findByName(name);
    }

    
}
