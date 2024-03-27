package br.com.blog.sunioweb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Coment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String PublisherName;

    private String PublisherEmail;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date date;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    @NotNull
    private String content;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Post post;
}
