package pl.myapp.java.javaDemoApiIntegration.adapter.out.rest;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.rest.ArticleRestOutPort;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceflightRestApiClient implements ArticleRestOutPort {
  private static final String API_URL = "https://api.spaceflightnewsapi.net/v4/articles";
  private final Gson gson;

//  public UserArticles newestUnreadArticles() {
//    List<Article> response = new ArrayList<>();
//    int offset = 0;
//    int limit = 20;
//
//    while (response.size() < 20) {
//      UserArticles articles = getArticlesPackage(offset, limit);
//      response.addAll(
//          articles.articles().stream().filter(article -> !readed.contains(article.id())).toList());
//      offset++;
//    }
//
//    readed.addAll(response.stream().map(article -> article.id()).toList());
//
//    if (response.size()) return new UserArticles(response);
//  }

//  private UserArticles getArticlesPackage(int offset, int limit) {
//    UserArticles articles =
//        this.restClient
//            .get()
//            .uri("?limit=" + limit + "&offset=" + offset + "&ordering=-published_at")
//            .retrieve()
//            .body(UserArticles.class);
//    return articles;
//  }

  @Override
  public List<Article> findLatestArticles(int numberOfArticles) {

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(prepareUrl(numberOfArticles)))
      .header("content-type", "application/json")
      .header("accept", "application/json")
      .build();
    HttpResponse<String> response;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    SpaceflightArticlesResponse objectResponse = gson.fromJson(response.body(), SpaceflightArticlesResponse.class);
    return objectResponse.articles().stream().map(SpaceflightArticlesResponse.ArticleInList::toDomain).toList();
  }

  @Override
  public List<Article> findLatestUnreadArticles(int numberOfArticles) {
    return List.of();
  }

  private String prepareUrl(int numberOfArticles) {
    return String.format("%s/?limit=%d&ordering=-published_at", API_URL, numberOfArticles);
  }
}
