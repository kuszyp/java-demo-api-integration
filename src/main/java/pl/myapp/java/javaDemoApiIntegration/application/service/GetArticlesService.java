package pl.myapp.java.javaDemoApiIntegration.application.service;

import pl.myapp.java.javaDemoApiIntegration.application.port.out.rest.ArticleRestOutPort;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;
import pl.myapp.java.javaDemoApiIntegration.application.port.in.GetArticlesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetArticlesService implements GetArticlesUseCase {

  private final ArticleRestOutPort articleRestOutPort;

  @Override
  public List<Article> getLatestArticles(int limit) {
    return articleRestOutPort.findLatestArticles(limit);
  }

  @Override
  public List<Article> getUnreadArticles(int limit) {
    return null;
  }
}
