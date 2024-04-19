package pe.joedayz.restapis.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.joedayz.restapis.domains.TodoType;
import pe.joedayz.restapis.repositories.TodoTypeRepository;

@Service
public class TodoTypeService {

 private TodoTypeRepository todoTypeRepository;
 private Validator validator;

 @Autowired
  public TodoTypeService(TodoTypeRepository todoTypeRepository, Validator validator) {
    this.todoTypeRepository = todoTypeRepository;
    this.validator = validator;
  }

  public TodoType create(TodoType todoType) {
    Set<ConstraintViolation<TodoType>> violations = validator.validate(todoType);
    if(violations.size() <1){ // no hay errores de validacion
      todoTypeRepository.save(todoType);
    }
    return todoType;
  }

  public TodoType findByCode(String code) {
    Optional<TodoType> todoTypeResult = todoTypeRepository.findById(code);
    if (todoTypeResult.isPresent()) {
      return todoTypeResult.get();
    } else {
      return null;
    }
  }

  public TodoType update(TodoType todoType) {
    todoType.setLastUpdated(new Date());
    todoType = todoTypeRepository.save(todoType);
    return todoType;
  }

  public void deleteByCode(String code) throws Exception {
    if (!todoTypeRepository.existsById(code)) {
      throw new Exception("TodoType doesn't exist");
    }
    todoTypeRepository.deleteById(code);
  }
}
