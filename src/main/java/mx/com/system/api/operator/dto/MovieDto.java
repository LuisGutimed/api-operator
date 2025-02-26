package mx.com.system.api.operator.dto;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class MovieDto implements Serializable {

  private static final long serialVersionUID = -184704388891106972L;

  private String id;
  private String title;
  private String genre;
  private String director;
  private String description;
  private double rentPrice;
  private String coverImageUrl;
  private String thrillerUrl;

}
