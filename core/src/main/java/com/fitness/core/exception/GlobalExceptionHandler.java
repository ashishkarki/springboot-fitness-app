package com.fitness.core.exception;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fitness.core.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidExceptions(
      MethodArgumentNotValidException ex) {
    logger.debug("Handling validation exception: {}", ex.getMessage());
    String errorMessage = ex.getBindingResult().getFieldErrors()
        .stream().map(error -> error.getField() + ": " + error.getDefaultMessage())
        .collect(Collectors.joining(", "));

    return ResponseEntity.badRequest().body(ApiResponse.error(errorMessage));
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiResponse<Object>> handleIllegalArgumentException(
      IllegalArgumentException ex) {
    logger.warn("Illegal argument exception: {}", ex.getMessage());
    return ResponseEntity.badRequest().body(ApiResponse.error(ex.getMessage()));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ApiResponse<Object>> handleRuntimeException(
      RuntimeException ex) {
    logger.error("Runtime exception: {}", ex.getMessage(), ex);
    return ResponseEntity.internalServerError()
        .body(ApiResponse.error("An internal error occurred"));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Object>> handleGenericException(
      Exception ex) {
    logger.error("Unexpected exception: {}", ex.getMessage(), ex);
    return ResponseEntity.internalServerError()
        .body(ApiResponse.error("An unexpected error occurred"));
  }

}
