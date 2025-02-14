package mx.com.system.api.operator.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDto implements Serializable {

  @Serial
  private static final long serialVersionUID = -184704388891106972L;

  private String id;
  private String name;
  private String description;
  private String image;
  private boolean status;
  private double price;
  private CategoryDto category;

}
