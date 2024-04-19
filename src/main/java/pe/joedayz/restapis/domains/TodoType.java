package pe.joedayz.restapis.domains;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import jakarta.xml.bind.annotation.XmlType;
import java.util.Date;
import lombok.Data;


@Data
@JsonPropertyOrder(alphabetic = true)
//@JsonPropertyOrder({"description", "code"})
//@JsonInclude(JsonInclude.Include.NON_NULL) // or NON_EMPTY, ALWAYS, CUSTOM
@XmlRootElement// cambiamos el root element
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "code", "dateCreated", "lastUpdated" })
public class TodoType {
  private String code;
  @XmlTransient
  private String description;
  //@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private Date dateCreated;
  //@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private Date lastUpdated;

}
