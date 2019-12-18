package kr.pe.jonghak.example.bbs.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDateTime;

@Data
@Relation(value = "article", collectionRelation = "articles")
public class ArticleModel extends RepresentationModel<ArticleModel> {

    Long id;
    String title;
    String authorId;
    String authorName;
    String authorEmail;
    LocalDateTime created;
    LocalDateTime lastUpdated;
    String contents;
}
