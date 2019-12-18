package kr.pe.jonghak.example.bbs.controller;

import kr.pe.jonghak.example.bbs.model.Article;
import kr.pe.jonghak.example.bbs.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public Page<Article> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id) {
        return articleRepository.findById(id).get();
    }
}