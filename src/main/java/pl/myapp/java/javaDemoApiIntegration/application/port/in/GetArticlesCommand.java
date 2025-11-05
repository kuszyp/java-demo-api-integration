package pl.myapp.java.javaDemoApiIntegration.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record GetArticlesCommand(Integer limit) {

  public GetArticlesCommand(@NotNull @Positive Integer limit) {

    this.limit = limit;
    Validator.validate(this);
  }
}
