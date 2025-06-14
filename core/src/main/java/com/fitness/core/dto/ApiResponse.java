package com.fitness.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
  private boolean success;
  private T data;
  private String errorMessage;

  public static <T> ApiResponse<T> success(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Success response data cannot be null");
    }
    return new ApiResponse<T>(true, data, null);
  }

  public static <T> ApiResponse<T> error(String errorMessage) {
    if (errorMessage == null || errorMessage.trim().isEmpty()) {
      throw new IllegalArgumentException("Error message cannot be null or empty");
    }
    return new ApiResponse<T>(false, null, errorMessage);
  }
}
