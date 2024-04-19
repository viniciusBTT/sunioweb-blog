package br.com.blog.sunioweb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String name;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date publication;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date lastUpdate;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    @NotNull
    private String content;

    private Boolean visibility;


    @ManyToMany
    private List<Subject> subjects;

    public Post(String name, String content, List<Subject> subjects, Boolean visibility){
        this.name = name;
        this.content = content;
        this.subjects.addAll(subjects);
        this.visibility = visibility;
    }

    public Post(){}

}
