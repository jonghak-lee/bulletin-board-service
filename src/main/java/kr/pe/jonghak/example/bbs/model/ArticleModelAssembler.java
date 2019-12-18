package kr.pe.jonghak.example.bbs.model;

import kr.pe.jonghak.example.bbs.client.AuthorClient;
import kr.pe.jonghak.example.bbs.controller.ArticleController;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ArticleModelAssembler extends RepresentationModelAssemblerSupport<Article, ArticleModel> {

    private AuthorClient authorClient;

    public ArticleModelAssembler(AuthorClient authorClient) {
        super(ArticleController.class, ArticleModel.class);
        this.authorClient = authorClient;
    }

    @Override
    public ArticleModel toModel(Article entity) {
        return createModelWithId(entity.getId(), entity);
    }

    @Override
    protected ArticleModel instantiateModel(Article entity) {
        ArticleModel model = new ArticleModel();
        BeanUtils.copyProperties(entity, model);
        model.setAuthor(authorClient.getAuthor(entity.getAuthorId()));
        return model;
    }
}
