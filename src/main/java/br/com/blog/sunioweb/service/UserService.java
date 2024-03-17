package br.com.blog.sunioweb.service;

import br.com.blog.sunioweb.dto.UserPostDTO;
import br.com.blog.sunioweb.model.Role;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;



    public List<User> findAll(){return repository.findAll();}
    public User save(UserPostDTO dto)
    {
       User user = repository.save(new User(dto.username(), dto.password(), new Role(dto.roles())));

        return user;
    }

    public User verifyByUser(String username){

        return repository.findById(username).orElse(null);
    }

    public User findById(String username){
        return repository.findById(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = this.repository.findById(username).orElse(null);

        if(user != null)
        {
            if(user.getAuthorities().isEmpty())
            {
                user.addRole(new Role("ROLE_COMUM"));
            }
        }

        if(user == null) throw new UsernameNotFoundException("Usuário ou senha inválidos");

        return user;
    }


}
