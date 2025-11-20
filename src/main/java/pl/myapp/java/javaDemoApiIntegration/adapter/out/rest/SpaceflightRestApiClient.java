package pl.myapp.java.javaDemoApiIntegration.adapter.out.rest;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.rest.ArticleRestRepository;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@AllArgsConstructor
public class SpaceflightRestApiClient implements ArticleRestRepository {
  private final Gson gson;
  private final SpaceflightApiProperties properties;

  @Override
  public List<Article> findLatestArticles(int limit, int offset) {
    final SpaceflightArticlesResponse apiResponse = callSpaceflightRestApi(limit, offset);
    return apiResponse.articles().stream()
        .map(SpaceflightArticlesResponse.ArticleInList::toDomain)
        .toList();
  }

  private SpaceflightArticlesResponse callSpaceflightRestApi(int limit, int offset) {
    final String url = buildUrl(properties, limit, offset);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request =
        HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("content-type", "application/json")
            .header("accept", "application/json")
            .build();
    HttpResponse<String> response;
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      client.close();
    }
    return gson.fromJson(response.body(), SpaceflightArticlesResponse.class);
  }

  private String buildUrl(SpaceflightApiProperties properties, int limit, int offset) {
    final String url = "%s%s/?ordering=-published_at&limit=%d&offset=%d";
    return String.format(url, properties.baseUrl(), properties.articlesUrl(), limit, offset);
  }
}
