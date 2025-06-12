package org.example.huiswerktechiteasy.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidEnumException.class)
  public ResponseEntity<String> handleInvalidEnumException(InvalidEnumException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<String> handleInvalidEnumDuringDeserialization(HttpMessageNotReadableException e) {
    if (e.getCause() instanceof InvalidFormatException ife && !ife.getPath().isEmpty()) {
      String fieldName = ife.getPath().get(0).getFieldName();
      String invalidValue = ife.getValue().toString();
      String message = "Ongeldige waarde voor veld '" + fieldName + "': '" + invalidValue + "'.";
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>("Fout bij verwerken van aanvraag", HttpStatus.BAD_REQUEST);
  }
}
