package pl.myapp.java.javaDemoApiIntegration.adapter.in.rest;

import static pl.myapp.java.javaDemoApiIntegration.adapter.in.rest.RestCommons.clientErrorException;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.myapp.java.javaDemoApiIntegration.application.port.in.GetArticlesUseCase;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

@RequestMapping("/articles")
public interface ArticleBrowseController {

  @GetMapping("")
  List<UserArticleResponse> getLatestArticles(@RequestParam int limit);

  @GetMapping("/unread")
  List<UserArticleResponse> getLatestUnreadArticles(@RequestParam int limit);
}

@RestController
@RequiredArgsConstructor
class ArticleBrowseControllerImpl implements ArticleBrowseController {

  private final GetArticlesUseCase articlesUseCase;

  @Override
  public List<UserArticleResponse> getLatestArticles(@RequestParam(defaultValue = "15") int limit) {
    if (limit < 1) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Invalid limit request parameter");
    }

    List<Article> response;

    try {
      response = articlesUseCase.getLatestArticles(limit);
    } catch (RuntimeException e) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    return response.stream().map(UserArticleResponse::fromDomainModel).toList();
  }

  @Override
  public List<UserArticleResponse> getLatestUnreadArticles(@RequestParam(defaultValue = "5") int limit) {
    if (limit < 1) {
      throw clientErrorException(HttpStatus.BAD_REQUEST, "Invalid limit request parameter");
    }

    return articlesUseCase.getLatestUnreadArticles(limit).stream()
        .map(UserArticleResponse::fromDomainModel)
        .toList();
  }
}
