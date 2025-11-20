package pl.myapp.java.javaDemoApiIntegration.adapter.out.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api.spaceflight")
record SpaceflightApiProperties(String baseUrl, String articlesUrl) { }
