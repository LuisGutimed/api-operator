package mx.com.system.api.operator.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorDetail implements Serializable {

  @Serial
  private static final long serialVersionUID = -5537059934816341632L;

  private String message;
  private String details;
  private String timestamp;
}
