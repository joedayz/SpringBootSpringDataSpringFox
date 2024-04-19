package pe.joedayz.restapis.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import pe.joedayz.restapis.domains.TodoType;

@Service
public class TodoTypeService {

  private static Map<String, TodoType> todoTypeCollection = new HashMap<>();


  public TodoType create(TodoType todoType) {
    todoTypeCollection.put(todoType.getCode(), todoType);
    return todoType;
  }

  public TodoType findByCode(String code) {
    return todoTypeCollection.get(code);
  }

  public TodoType update(TodoType todoType) {
    todoType.setLastUpdated(new Date());
    todoTypeCollection.put(todoType.getCode(), todoType);
    return todoType;
  }

  public void deleteByCode(String code) throws Exception {
    if (todoTypeCollection.remove(code) == null) {
      throw new Exception("TodoType doesn't exist");
    }
  }
}
