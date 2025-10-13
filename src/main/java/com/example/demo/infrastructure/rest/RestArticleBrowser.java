package com.example.demo.infrastructure.rest;

import com.example.demo.application.domain.service.ArticleBrowser;
import com.example.demo.application.domain.model.UserArticles;
import com.example.demo.interfaces.rest.SpaceflightRestApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestArticleBrowser implements ArticleBrowser {

  private final SpaceflightRestApiClient client;

  @Override
  public UserArticles getNewestArticles(int offset, int limit) {
    return client.newestArticles();
  }
}
