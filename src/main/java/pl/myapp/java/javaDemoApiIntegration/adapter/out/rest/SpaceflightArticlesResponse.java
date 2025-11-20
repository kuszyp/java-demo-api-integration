package pl.myapp.java.javaDemoApiIntegration.adapter.out.rest;

import com.google.gson.annotations.SerializedName;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

import java.util.List;

record SpaceflightArticlesResponse(
    int count,
    String next,
    String previous,
    @SerializedName("results") List<ArticleInList> articles) {

  public record ArticleInList(
      int id, String title, String url, String summary, String publishedAt) {

    public Article toDomain() {
      return new Article(id, title, summary, publishedAt);
    }
  }
}
