package br.com.blog.sunioweb.repository;

import br.com.blog.sunioweb.model.Coment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentRepository extends JpaRepository<Coment,Integer> {

}