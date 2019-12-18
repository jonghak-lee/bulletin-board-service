package kr.pe.jonghak.example.bbs.model;

import kr.pe.jonghak.example.bbs.client.UserClient;
import kr.pe.jonghak.example.bbs.controller.ArticleController;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ArticleModelAssembler extends RepresentationModelAssemblerSupport<Article, ArticleModel> {

    private UserClient userClient;

    public ArticleModelAssembler(UserClient userClient) {
        super(ArticleController.class, ArticleModel.class);
        this.userClient = userClient;
    }

    @Override
    public ArticleModel toModel(Article article) {
        return this.createModelWithId(article.getId(), article);
    }

    @Override
    protected ArticleModel instantiateModel(Article entity) {
        ArticleModel model = new ArticleModel();
        BeanUtils.copyProperties(entity, model);
        User author = userClient.getUser(entity.getAuthorId());
        model.setAuthorName(author.getName());
        model.setAuthorEmail(author.getEmail());
        return model;
    }
}
