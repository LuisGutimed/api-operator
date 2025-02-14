package mx.com.system.api.operator.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PromotionDto implements Serializable {

  @Serial
  private static final long serialVersionUID = 5627877665103831637L;
  private String id;
  private String name;
  private String image;
  private String description;
  private Date startDate;
  private Date endDate;
  private boolean status;

}
