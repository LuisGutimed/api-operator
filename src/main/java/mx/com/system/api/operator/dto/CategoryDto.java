package mx.com.system.api.operator.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 6642645480686406327L;
  private String id;
  private String name;
  private String description;

}
