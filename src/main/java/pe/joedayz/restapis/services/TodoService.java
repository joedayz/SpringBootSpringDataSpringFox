package pe.joedayz.restapis.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import pe.joedayz.restapis.domains.Todo;

@Service  // proveernos una instancia SINGLETON de esta clase
public class TodoService {

  private static Map<Long, Todo> todoCollection  = new HashMap<>();
  private static long idCount = 1L;

  public Todo create(Todo todo) {
    todo.setId(idCount);
    todoCollection.put(idCount, todo);
    idCount++;
    return todo;
  }

  public Todo findById(Long id) {
    return todoCollection.get(id);
  }

  public Todo update(Todo todo) {
    todo.setLastUpdated(new Date());
    if(todo.isDone()){
      todo.setDateDone(new Date());
    }
    todoCollection.put(todo.getId(), todo);
    return todo;
  }

  public void deleteById(Long id) throws Exception{
    if(todoCollection.remove(id) == null){
      throw new Exception("No existe ese Id");
    }
  }
}
