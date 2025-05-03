package com.fitness.activityservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActivityResponse extends BaseActivityDto {
    private String id;
}
