package com.fitness.activityservice.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fitness.activityservice.dto.ActivityResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "activities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    private String id;

    private String userId;

    private ActivityType type;

    private Integer duration;

    private Integer caloriesBurned;

    private LocalDateTime startTime;

    @Field("metrics")
    private Map<String, Object> additionalMetrics;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * Transforms the current Activity object to an ActivityResponse object.
     *
     * @return An ActivityResponse object representing the current Activity
     */
    public ActivityResponse toActivityResponse() {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(this.id);
        activityResponse.setUserId(this.userId);
        activityResponse.setType(this.type);
        activityResponse.setDuration(this.duration);
        activityResponse.setCaloriesBurned(this.caloriesBurned);
        activityResponse.setStartTime(this.startTime);
        activityResponse.setAdditionalMetrics(this.additionalMetrics);
        activityResponse.setCreatedAt(this.createdAt);
        activityResponse.setUpdatedAt(this.updatedAt);

        return activityResponse;
    }
}
