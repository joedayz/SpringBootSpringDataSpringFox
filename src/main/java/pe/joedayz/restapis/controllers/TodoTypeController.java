package pe.joedayz.restapis.controllers;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.restapis.domains.TodoType;
import pe.joedayz.restapis.services.TodoTypeService;

@RestController  // Combina @Controller y @ResponseBody
@RequestMapping("/api/todoType")  // Mapea los web requests a /api/todoType
public class TodoTypeController {


  private TodoTypeService todoTypeService;


  @Autowired
  public TodoTypeController(TodoTypeService todoTypeService) {
    this.todoTypeService = todoTypeService;
  }

  @GetMapping("/hello")  // Solo maneja peticiones GET
  public String hello() {
    return "Hello World from Spring Boot !";
  }

  /**
   * expose GetMapping en el /read endpoint
   * @return TodoType
   */
  @GetMapping(value="/read", produces = {"application/json", "application/xml"})
  public TodoType readTodoType(){
    TodoType todoType = new TodoType();
    todoType.setCode("PERSONAL");
    todoType.setDescription("Todo para personal work");
    return todoType;
  }

  @PostMapping(value="/create", produces = {"application/json", "application/xml"})
  public TodoType createTodoType(){
    TodoType todoType = new TodoType();
    todoType.setCode("PROFESSIONAL");
    todoType.setDescription("Todo para professional work");
    return todoType;
  }

  @PostMapping(consumes={"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public TodoType create(@RequestBody TodoType todoType) {
    return todoTypeService.create(todoType);
  }

  @GetMapping(value = "/{code}", produces = {"application/xml"})
  public TodoType read(@PathVariable("code") String code) {
    TodoType todoType = todoTypeService.findByCode(code);
    return todoType;
  }

  @PutMapping
  public TodoType updateTodo(@RequestBody TodoType todoType) {
    return todoTypeService.update(todoType);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity delete(@PathVariable("code") String code) {
    try {
      todoTypeService.deleteByCode(code);
      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }

}
