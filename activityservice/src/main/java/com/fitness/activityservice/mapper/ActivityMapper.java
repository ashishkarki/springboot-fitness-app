package com.fitness.activityservice.mapper;

import org.mapstruct.Mapper;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;

@Mapper(componentModel = "spring")
/**
 * Mapper interface for converting between Activity objects using MapStruct.
 * Provides methods to transform Activity instances for request and response
 * scenarios.
 */
public interface ActivityMapper {
  ActivityResponse toActivityResponse(Activity activity);

  Activity toActivity(ActivityRequest activityRequest);
}
