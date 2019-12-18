package kr.pe.jonghak.example.bbs.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Data
public class ArticleModel extends RepresentationModel<ArticleModel> {

    private Long id;
    private String title;
    private Author author;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private String contents;
}
