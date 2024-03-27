package br.com.blog.sunioweb.service;

import br.com.blog.sunioweb.model.Post;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){return repository.findAll();}

    public Post findById(Integer id){return  repository.findById(id).orElse(null);}

    public Post save (Post post){


        return repository.save(post);
    }

}
