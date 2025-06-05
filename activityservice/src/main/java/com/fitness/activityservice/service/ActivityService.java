package com.fitness.activityservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository activityRepository;

  /**
   * Saves an activity to the database.
   *
   * @param activityRequest contains the activity information
   * @return the saved activity as a response
   */
  public ActivityResponse trackActivity(ActivityRequest activityRequest) {
    // Create an activity from the request
    Activity activity = Activity.builder()
        .userId(activityRequest.getUserId())
        .type(activityRequest.getType())
        .duration(activityRequest.getDuration())
        .caloriesBurned(activityRequest.getCaloriesBurned())
        .startTime(activityRequest.getStartTime())
        .additionalMetrics(activityRequest.getAdditionalMetrics())
        .build();

    // Save the activity to the db
    Activity savedActivity = activityRepository.save(activity);

    // Return the saved activity as a response
    return savedActivity.toActivityResponse();
  }

  /**
   * Retrieves a list of activities for a specific user.
   *
   * @param userId the unique identifier of the user whose activities are to be
   *               fetched
   * @return a list of activity responses associated with the given user
   */
  public List<ActivityResponse> getActivitiesByUserId(String userId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getActivitiesByUserId'");
  }

}
