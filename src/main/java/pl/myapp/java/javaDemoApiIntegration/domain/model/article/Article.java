package pl.myapp.java.javaDemoApiIntegration.domain.model.article;

import java.time.Instant;

/**
 * Single article representation
 */
public record Article(int id, String title, String summary, String publishedAt) {}
