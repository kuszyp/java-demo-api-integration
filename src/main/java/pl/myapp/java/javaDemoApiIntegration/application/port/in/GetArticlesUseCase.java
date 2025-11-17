package pl.myapp.java.javaDemoApiIntegration.application.port.in;

import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.util.List;

/**
 * Use case: Retrieving articles list
 */
public interface GetArticlesUseCase {

  List<Article> getLatestArticles(int limit);

  List<Article> getUnreadArticles(int limit);
}
