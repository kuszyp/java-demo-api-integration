package pl.myapp.java.javaDemoApiIntegration.application.service;

import pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence.ArticlePersistenceRepository;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.rest.ArticleRestRepository;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;
import pl.myapp.java.javaDemoApiIntegration.application.port.in.GetArticlesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticlesService implements GetArticlesUseCase {
  private static final int DEFAULT_OFFSET = 0;
  private final ArticleRestRepository articleRestRepository;
  private final ArticlePersistenceRepository persistenceRepository;

  @Override
  public List<Article> getLatestArticles(int limit) {
    return articleRestRepository.findLatestArticles(limit, DEFAULT_OFFSET);
  }

  @Override
  public List<Article> getLatestUnreadArticles(int limit) {

  }
}
