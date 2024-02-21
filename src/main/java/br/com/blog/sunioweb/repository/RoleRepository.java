package br.com.blog.sunioweb.repository;

import br.com.blog.sunioweb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
