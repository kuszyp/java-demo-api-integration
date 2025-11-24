package pl.myapp.java.javaDemoApiIntegration.application.service;

import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.myapp.java.javaDemoApiIntegration.application.port.in.GetArticlesUseCase;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence.ArticlePersistenceRepository;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.rest.ArticleRestRepository;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

@Service
@RequiredArgsConstructor
public class GetArticlesService implements GetArticlesUseCase {

  private static final int DEFAULT_OFFSET = 0;
  private static final int MAX_ITERATIONS = 10;
  private final ArticleRestRepository articleRestRepository;
  private final ArticlePersistenceRepository persistenceRepository;

  @Override
  public List<Article> getLatestArticles(int limit) {
    return articleRestRepository.findLatestArticles(limit, DEFAULT_OFFSET);
  }

  @Override
  public List<Article> getLatestUnreadArticles(int limit) {
    Set<Article> unreadArticles = new LinkedHashSet<>();
    int iteration = 0;
    int offset = persistenceRepository.size();
    while (unreadArticles.size() < limit && ++iteration < MAX_ITERATIONS) {
      int requestLimit = limit - unreadArticles.size();
      List<Article> articles = articleRestRepository.findLatestArticles(requestLimit, offset);
      unreadArticles.addAll(
        articles.stream()
          .filter(article -> persistenceRepository.findById(article.id()).isEmpty())
          .toList());
      offset += requestLimit;
    }

    if (iteration >= MAX_ITERATIONS) {
      throw new RuntimeException("Too many REST queries for articles!!!");
    }

    persistenceRepository.saveAll(unreadArticles);
    return new ArrayList<>(unreadArticles);
  }
}
