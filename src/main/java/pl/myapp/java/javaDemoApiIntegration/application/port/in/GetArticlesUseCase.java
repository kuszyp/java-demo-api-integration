package pl.myapp.java.javaDemoApiIntegration.application.port.in;

import java.util.List;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

/** Use case: Retrieving articles list */
public interface GetArticlesUseCase {

  List<Article> getLatestArticles(int limit);

  List<Article> getLatestUnreadArticles(int limit);
}
