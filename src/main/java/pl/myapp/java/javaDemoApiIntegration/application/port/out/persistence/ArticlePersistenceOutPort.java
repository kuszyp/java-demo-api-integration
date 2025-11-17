package pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence;

import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.util.Optional;

/**
 * A repository to handle articles that was already read by the user
 */
public interface ArticlePersistenceOutPort {
  void save(Article article);

  Optional<Article> findById(int id);
}
