package com.fitness.core.exception;

import types.EntityType;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(EntityType entityType, Object id) {
    super(entityType.toString() + " with id " + id + " not found");
  }
}
