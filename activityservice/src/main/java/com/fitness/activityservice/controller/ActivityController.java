package com.fitness.activityservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import com.fitness.core.dto.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
  private final ActivityService activityService;

  @PostMapping
  public ResponseEntity<ApiResponse<ActivityResponse>> trackActivity(
      @Valid @RequestBody ActivityRequest activityRequest) {
    try {
      log.debug("Tracking activity for user: {}", activityRequest.getUserId());
      ActivityResponse activityResponse = activityService.trackActivity(activityRequest);
      return ResponseEntity.ok(ApiResponse.success(activityResponse));
    } catch (Exception e) {
      log.error("Error tracking activity", e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(e.getMessage()));
    }
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<ActivityResponse>>> getActivitiesByUserId(
      @RequestHeader("X-User-Id") String userId) {
    try {
      List<ActivityResponse> activities = activityService.getActivitiesByUserId(userId);
      return ResponseEntity.ok(ApiResponse.success(activities));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(e.getMessage()));
    }
  }

  @GetMapping("/{activityId}")
  public ResponseEntity<ApiResponse<ActivityResponse>> getActivityById(@PathVariable String activityId) {
    try {
      ActivityResponse activity = activityService.getActivityById(activityId);
      return ResponseEntity.ok(ApiResponse.success(activity));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(e.getMessage()));
    }
  }

}
