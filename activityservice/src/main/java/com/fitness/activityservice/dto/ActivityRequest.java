package com.fitness.activityservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
/**
 * Represents a request for creating or updating an activity in the fitness
 * tracking system.
 * Extends BaseActivityDto to inherit common activity-related properties.
 */
public class ActivityRequest extends BaseActivityDto {
}
