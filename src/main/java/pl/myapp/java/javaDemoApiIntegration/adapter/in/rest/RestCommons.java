package pl.myapp.java.javaDemoApiIntegration.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class RestCommons {
  private RestCommons() {}


  public static ClientErrorException clientErrorException(HttpStatus status, String message) {
    return new ClientErrorException(errorResponse(status, message));
  }

  public static ResponseEntity<ErrorEntity> errorResponse(HttpStatus status, String message) {
    ErrorEntity error = new ErrorEntity(status.value(), message);
    return ResponseEntity.status(status.value()).body(error);
  }
}
