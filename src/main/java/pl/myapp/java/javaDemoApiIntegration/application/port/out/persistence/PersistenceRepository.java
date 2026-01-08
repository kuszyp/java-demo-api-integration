package pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence;

import java.util.Collection;
import java.util.Optional;

/** A repository to handle articles that was already read by the user */
public interface PersistenceRepository<E> {
  void save(E element);

  void saveAll(Collection<E> collection);

  Optional<E> findById(int id);

  int size();
}
