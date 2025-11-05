package pl.myapp.java.javaDemoApiIntegration.application.port.in;

import pl.myapp.java.javaDemoApiIntegration.application.domain.model.UserArticles;

/*
 * I use Service postfix to describe the use case it does.
 *
 * Usually, the use case follows there steps:
 *  1. Take an input
 *  2. Validate the business rules
 *  3. Manipulate the model state
 *  4. Return the output
 *
 * The services in port.in takes input from incoming adapters, ie. adapter.in.web
 * To persist the state of the domain, the service pass new state to a service in port.out implemented by
 * appropriate adapter, in this case adapter.out.persistence
 */
public interface BrowseArticlesUseCase {

  UserArticles getArticles(Integer limit);

  UserArticles getUnreadArticles(Integer limit);
}
