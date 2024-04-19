package pe.joedayz.restapis.domains;

import java.util.Date;
import lombok.Data;

@Data
public class Todo {
  private Long id;
  private String title;
  private String description;
  private boolean done;
  private Date dateCreated;
  private Date dueDate;
  private Date dateDone;
  private Date lastUpdated;

  private TodoType todoType;

}
