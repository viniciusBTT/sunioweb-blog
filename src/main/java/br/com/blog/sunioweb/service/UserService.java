package br.com.blog.sunioweb.service;

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

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;



//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        User user = repository.findById(1).orElse(null);
//
//        if(user != null)
//        {
//            if(user.getAuthorities().isEmpty())
//            {
//                user.addRole(new Role("ROLE_COMUM"));
//            }
//        }
//
//        if(user == null) throw new UsernameNotFoundException("Usuário ou senha inválidos");
//
//        return user;
//    }

    public User save(User user)
    {
        return repository.save(user);
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
