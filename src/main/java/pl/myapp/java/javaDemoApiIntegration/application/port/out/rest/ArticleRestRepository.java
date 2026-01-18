package pl.myapp.java.javaDemoApiIntegration.application.port.out.rest;

import java.util.List;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

/** Outgoing REST port for listing Articles */
public interface ArticleRestRepository {
  List<Article> findLatestArticles(int limit, int offset);
}
