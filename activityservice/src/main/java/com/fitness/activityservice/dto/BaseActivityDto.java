package com.fitness.activityservice.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fitness.activityservice.model.ActivityType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public abstract class BaseActivityDto {
  @NotBlank(message = "User ID is required")
  private String userId;

  @NotNull(message = "Activity type is required")
  private ActivityType type;

  @Positive(message = "Duration must be positive")
  private Integer duration; // in minutes

  @PositiveOrZero(message = "Calories burned cannot be negative")
  private Integer caloriesBurned;

  @NotNull(message = "Start time is required")
  private LocalDateTime startTime;

  private Map<String, Object> additionalMetrics;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
