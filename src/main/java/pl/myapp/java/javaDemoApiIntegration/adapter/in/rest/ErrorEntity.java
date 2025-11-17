package pl.myapp.java.javaDemoApiIntegration.adapter.in.rest;

/**
 * An error entity with a status and message returned using REST API
 */
public record ErrorEntity(int httpStatus, String errorMessage) {}
