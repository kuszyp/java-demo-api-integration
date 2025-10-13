package com.example.demo.adapter.in.web;

import com.example.demo.application.port.in.BrowseArticlesService;
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

  private final BrowseArticlesService articleBrowser;

  @Override
  public ResponseEntity<?> getArticles() {
    return null;
  }

  @Override
  public ResponseEntity<?> getUnreadArticles() {
    return null;
  }
}
