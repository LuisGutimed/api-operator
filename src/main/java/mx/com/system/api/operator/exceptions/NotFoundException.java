package mx.com.system.api.operator.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 2702106491666356072L;

  public NotFoundException(String message) {
    super(message);
  }
}
