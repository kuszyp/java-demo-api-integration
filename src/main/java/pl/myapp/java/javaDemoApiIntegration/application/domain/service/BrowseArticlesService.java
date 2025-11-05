package pl.myapp.java.javaDemoApiIntegration.application.domain.service;

import pl.myapp.java.javaDemoApiIntegration.application.domain.model.UserArticles;
import pl.myapp.java.javaDemoApiIntegration.application.port.in.BrowseArticlesUseCase;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.LoadArticlesPort;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.UpdateUserArticlesPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrowseArticlesService implements BrowseArticlesUseCase {

  private final LoadArticlesPort loadArticlesPort;
  private final UpdateUserArticlesPort updateUserArticlesPort;

  @Override
  public UserArticles getArticles(Integer limit) {
    // TODO: perform business validation
    // TODO: manipulate model state
    // TODO: return output
    return null;
  }

  @Override
  public UserArticles getUnreadArticles(Integer limit) {
    return null;
  }
}
