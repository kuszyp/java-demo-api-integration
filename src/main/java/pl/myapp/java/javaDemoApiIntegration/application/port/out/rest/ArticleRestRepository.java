package pl.myapp.java.javaDemoApiIntegration.application.port.out.rest;

import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.util.List;

/**
 * Outgoing REST port for listing Articles
 */
public interface ArticleRestRepository {
  List<Article> findLatestArticles(int limit, int offset);
}
