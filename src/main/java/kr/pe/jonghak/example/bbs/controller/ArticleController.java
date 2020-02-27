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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AuthorClient authorClient;

    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public PagedModel<ArticleModel> getArticles(Pageable pageable, PagedResourcesAssembler<Article> assembler) {
        return assembler.toModel(articleRepository.findAll(pageable), new ArticleModelAssembler(authorClient));
    }

    @GetMapping("/{id}")
    public ArticleModel getArticle(@PathVariable("id") Long id) {
        if (httpSession.getAttribute("article-test") != null) {
            System.out.println("I know you!!");
            System.out.println(httpSession.getAttribute("article-test").toString());
        } else {
            httpSession.setAttribute("article-test", id);
            System.out.println("Who are you!!");
        }
        return new ArticleModelAssembler(authorClient).toModel(articleRepository.findById(id).get());
    }
}
