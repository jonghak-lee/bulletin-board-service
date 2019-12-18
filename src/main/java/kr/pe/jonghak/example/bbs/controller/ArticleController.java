package kr.pe.jonghak.example.bbs.controller;

import kr.pe.jonghak.example.bbs.client.AuthorClient;
import kr.pe.jonghak.example.bbs.model.Article;
import kr.pe.jonghak.example.bbs.model.ArticleModel;
import kr.pe.jonghak.example.bbs.model.ArticleModelAssembler;
import kr.pe.jonghak.example.bbs.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AuthorClient authorClient;

    @GetMapping
    public PagedModel<ArticleModel> getArticles(Pageable pageable, PagedResourcesAssembler<Article> assembler) {
        return assembler.toModel(articleRepository.findAll(pageable), new ArticleModelAssembler(authorClient));
    }

    @GetMapping("/{id}")
    public ArticleModel getArticle(@PathVariable("id") Long id) {
        return new ArticleModelAssembler(authorClient).toModel(articleRepository.findById(id).get());
    }
}
