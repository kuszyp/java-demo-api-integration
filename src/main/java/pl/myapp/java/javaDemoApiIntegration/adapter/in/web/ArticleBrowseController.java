package pl.myapp.java.javaDemoApiIntegration.adapter.in.web;

import pl.myapp.java.javaDemoApiIntegration.application.port.in.BrowseArticlesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/articles")
public interface ArticleBrowseController {

  @GetMapping("/")
  ResponseEntity<?> getArticles();

  @GetMapping("/unread")
  ResponseEntity<?> getUnreadArticles();
}

@RestController
@RequiredArgsConstructor
class ArticleBrowseControllerImpl implements ArticleBrowseController {

  private final BrowseArticlesUseCase articleBrowser;

  @Override
  public ResponseEntity<?> getArticles() {
    return null;
  }

  @Override
  public ResponseEntity<?> getUnreadArticles() {
    return null;
  }
}
