package com.fitness.activityservice.mapper;

import org.springframework.stereotype.Component;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;

/**
 * Mapper interface for converting between Activity objects using MapStruct.
 * Provides methods to transform Activity instances for request and response
 * scenarios.
 */
@Component
public class ActivityMapper {
  public ActivityResponse toActivityResponse(Activity activity) {
    ActivityResponse response = new ActivityResponse();

    response.setId(activity.getId());
    response.setUserId(activity.getUserId());
    response.setType(activity.getType());
    response.setDuration(activity.getDuration());
    response.setCaloriesBurned(activity.getCaloriesBurned());
    response.setStartTime(activity.getStartTime());
    response.setAdditionalMetrics(activity.getAdditionalMetrics());
    response.setCreatedAt(activity.getCreatedAt());
    response.setUpdatedAt(activity.getUpdatedAt());

    return response;
  }

  public Activity toActivity(ActivityRequest activityRequest) {
    Activity activity = new Activity();

    activity.setUserId(activityRequest.getUserId());
    activity.setType(activityRequest.getType());
    activity.setDuration(activityRequest.getDuration());
    activity.setCaloriesBurned(activityRequest.getCaloriesBurned());
    activity.setStartTime(activityRequest.getStartTime());
    activity.setAdditionalMetrics(activityRequest.getAdditionalMetrics());

    return activity;
  }
}
