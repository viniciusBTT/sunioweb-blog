package br.com.blog.sunioweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @OneToOne
    private Subject subject;



}
