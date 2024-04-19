package pe.joedayz.restapis.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.joedayz.restapis.domains.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

  @Query("SELECT t FROM Todo t WHERE t.done = true")
  List<Todo> readAllDone();
  List<Todo> findAllDone();
  List<Todo> findAllTitle(String title); //finders

  long countAllByDone(boolean done);

  long deleteAllByDone(boolean done);
}
