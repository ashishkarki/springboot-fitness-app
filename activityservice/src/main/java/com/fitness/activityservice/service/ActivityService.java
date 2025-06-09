package com.fitness.activityservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.mapper.ActivityMapper;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository activityRepository;
  private final ActivityMapper activityMapper;

  /**
   * Saves an activity to the database.
   *
   * @param activityRequest contains the activity information
   * @return the saved activity as a response
   */
  public ActivityResponse trackActivity(ActivityRequest activityRequest) {
    // Convert the request to an Activity object
    Activity activity = activityMapper.toActivity(activityRequest);

    // Save the activity to the db
    Activity savedActivity = activityRepository.save(activity);

    // Return the saved activity as a response
    return activityMapper.toActivityResponse(savedActivity);
  }

  /**
   * Retrieves a list of activities for a specific user.
   *
   * @param userId the unique identifier of the user whose activities are to be
   *               fetched
   * @return a list of activity responses associated with the given user
   */
  public List<ActivityResponse> getActivitiesByUserId(String userId) {
    // Fetch activities from the db
    List<Activity> activities = activityRepository.findByUserId(userId);

    // Convert activities to responses
    return activities.stream().map(activityMapper::toActivityResponse).toList();
  }

  public ActivityResponse getActivityById(String activityId) {
    // Fetch activities from the db by id (not by user id)
    Activity activity = activityRepository.findById(activityId)
        .orElseThrow(() -> new RuntimeException("Activity with id: " + activityId + " not found"));

    // Convert activities to responses
    return activityMapper.toActivityResponse(activity);
  }

}
