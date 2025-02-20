package mx.com.system.api.operator.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import mx.com.system.api.operator.dto.ErrorDetail;
import mx.com.system.api.operator.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorDetail> handleResourceNotFound(NotFoundException ex) {
    ErrorDetail errorDetail = new ErrorDetail(
        ex.getMessage(),
        "The resource you requested could not be found.",
        getFormattedTimestamp()
    );
    return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorDetail> handleIllegalArgument(IllegalArgumentException ex) {
    ErrorDetail errorDetail = new ErrorDetail(
        ex.getMessage(),
        "There was an invalid input provided.",
        getFormattedTimestamp()
    );
    return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetail> handleGenericException(Exception ex) {
    ex.printStackTrace();
    ErrorDetail errorDetail = new ErrorDetail(
        "Internal Server Error",
        ex.getMessage(),
        getFormattedTimestamp()
    );
    return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private String getFormattedTimestamp() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return LocalDateTime.now().format(formatter);
  }

}
