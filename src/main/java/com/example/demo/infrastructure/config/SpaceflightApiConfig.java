package com.example.demo.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.spaceflight")
public record SpaceflightApiConfig(String baseUrl, String articlesUrl) { }
