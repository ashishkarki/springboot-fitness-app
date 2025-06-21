package com.fitness.activityservice.service;

import java.time.Duration;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fitness.core.dto.ApiResponse;

import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidationService {
  private final WebClient userServiceWebClient;

  public boolean validateUser(String userId) {
    if (userId == null || userId.trim().isEmpty()) {
      throw new IllegalArgumentException("User ID cannot be null or empty");
    }

    try {
      // Make a request to the UserService to validate the user
      ApiResponse<Boolean> apiResponse = userServiceWebClient.get()
          .uri("/api/users/{userId}/validate", userId)
          // .retrieve()
          // .bodyToMono(new ParameterizedTypeReference<ApiResponse<Boolean>>() {
          // })
          .retrieve()
          .bodyToMono(new ParameterizedTypeReference<ApiResponse<Boolean>>() {
          })
          .timeout(Duration.ofSeconds(5))
          .retry(2)
          .block();

      if (apiResponse == null) {
        throw new RuntimeException("No response from UserService");
      }

      if (!apiResponse.isSuccess()) {
        throw new RuntimeException("Ashish Error validating user: " + userId);
      }

      return apiResponse.getData();
    } catch (WebClientResponseException wcre) {
      if (wcre.getStatusCode() == HttpStatus.NOT_FOUND) {
        throw new RuntimeException("User with id: " + userId + " not found");
      } else if (wcre.getStatusCode() == HttpStatus.BAD_REQUEST) {
        throw new BadRequestException("Bad request while validating user: " + userId);
      } else {
        throw new RuntimeException("karki..Error validating user: " + userId, wcre);
      }
    } catch (Exception e) {
      throw new RuntimeException("Unexpected error when validating user: " + userId, e);
    }
  }
}
