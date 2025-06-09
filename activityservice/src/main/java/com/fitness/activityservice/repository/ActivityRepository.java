package com.fitness.activityservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fitness.activityservice.model.Activity;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {

  /**
   * Finds activities by user ID.
   * Automatically implemented by Spring Data MongoDB.
   *
   * @param userId
   * @return
   */
  List<Activity> findByUserId(String userId);

}
