package br.com.blog.sunioweb.repository;

import br.com.blog.sunioweb.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Integer> {

    Subject findByName(String name);
}
