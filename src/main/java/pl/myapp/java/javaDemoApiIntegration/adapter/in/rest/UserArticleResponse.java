package pl.myapp.java.javaDemoApiIntegration.adapter.in.rest;

import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

public record UserArticleResponse(int id, String title, String summary) {

  public static UserArticleResponse fromDomainModel(Article article) {
    return new UserArticleResponse(article.id(), article.title(), article.summary());
  }
}
