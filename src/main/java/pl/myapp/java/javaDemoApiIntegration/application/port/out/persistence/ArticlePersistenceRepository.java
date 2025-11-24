package pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence;

import java.util.Collection;
import java.util.Optional;

/** A repository to handle articles that was already read by the user */
public interface ArticlePersistenceRepository<E> {
  void save(E article);

  void saveAll(Collection<E> collection);

  Optional<E> findById(int id);

  int size();
}
