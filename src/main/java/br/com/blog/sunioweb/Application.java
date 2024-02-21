package br.com.blog.sunioweb;

import br.com.blog.sunioweb.model.Role;
import br.com.blog.sunioweb.model.User;
import br.com.blog.sunioweb.repository.RoleRepository;
import br.com.blog.sunioweb.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Autowired
	private UserRepository userService;

	@Autowired
	private br.com.blog.sunioweb.repository.RoleRepository RoleRepository;

	@PostConstruct
	public void createDefaultUser()
	{

		Role roleComum = new Role("ROLE_COMUM");
		Role roleAdmin = new Role("ROLE_ADMIN");
		Role roleRoot = new Role("ROLE_ROOT");

		RoleRepository.save(roleComum);
		RoleRepository.save(roleAdmin);
		RoleRepository.save(roleRoot);

		userService.save(new User("admin", "123", new Role("ROLE_ADMIN")));
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
