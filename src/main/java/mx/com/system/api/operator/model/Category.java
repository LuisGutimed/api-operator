package mx.com.system.api.operator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category implements Serializable {


  @Serial
  private static final long serialVersionUID = -2401012312280509003L;
  @Id
  private String id;
  private String name;
  private String description;

}
