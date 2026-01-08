package pl.myapp.java.javaDemoApiIntegration.adapter.out.persistence;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Repository;
import pl.myapp.java.javaDemoApiIntegration.application.port.out.persistence.PersistenceRepository;
import pl.myapp.java.javaDemoApiIntegration.domain.model.article.Article;

@Repository
public class InMemoryRepository implements PersistenceRepository<Article> {

  private final ConcurrentMap<Integer, Article> storage = new ConcurrentHashMap<>();


  @Override
  public void save(Article element) {
    storage.put(element.id(), element);
  }

  @Override
  public void saveAll(Collection<Article> articles) {
    for (Article article : articles) {
      storage.put(article.id(), article);
    }
  }

  @Override
  public Optional<Article> findById(int id) {
    return Optional.ofNullable(storage.get(id));
  }

  @Override
  public int size() {
    return storage.size();
  }
}
