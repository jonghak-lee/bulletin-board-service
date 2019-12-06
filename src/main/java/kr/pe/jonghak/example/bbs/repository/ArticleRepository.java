package kr.pe.jonghak.example.bbs.repository;

import kr.pe.jonghak.example.bbs.model.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
