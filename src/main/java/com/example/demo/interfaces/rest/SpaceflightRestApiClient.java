package com.example.demo.interfaces.rest;

import com.example.demo.application.domain.model.Article;
import com.example.demo.application.domain.model.UserArticles;
import com.example.demo.infrastructure.config.SpaceflightApiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceflightRestApiClient {

  private final RestClient restClient;
  private final List<Integer> readed;

  public SpaceflightRestApiClient(
    SpaceflightApiConfig conf,
    RestClient.Builder restClientBuilder
  ) {
    this.restClient = restClientBuilder.baseUrl(conf.getArticlesPath()).build();
    readed = new ArrayList<>();
  }

  public UserArticles newestArticles() {
    return getArticlesPackage(0, 20);
  }

  public UserArticles newestUnreadArticles() {
    List<Article> response = new ArrayList<>();
    int offset = 0;
    int limit = 20;

    while (response.size() < 20) {
      UserArticles articles = getArticlesPackage(offset, limit);
      response.addAll(
        articles.results().stream()
        .filter(article -> !readed.contains(article.id()))
        .toList()
      );
      offset++;
    }



    readed.addAll(
      response.stream()
        .map(article -> article.id())
        .toList()
    );

    if (response.size() )

    return new UserArticles(response);
  }

  private UserArticles getArticlesPackage(int offset, int limit) {
    UserArticles articles = this.restClient.get().uri("?limit="+limit+"&offset="+offset+"&ordering=-published_at").retrieve().body(UserArticles.class);
    return articles;
  }


}
