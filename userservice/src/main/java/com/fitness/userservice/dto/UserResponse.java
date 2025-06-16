package com.fitness.userservice.dto;

import java.time.LocalDateTime;

import com.fitness.userservice.model.User;
import com.fitness.userservice.model.UserRole;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role = UserRole.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * Static factory method to create a UserResponse from a User entity.
     *
     * @param user the User entity to transform
     * @return a UserResponse containing the information of the User
     */
    public static UserResponse from(User user) {
        UserResponse response = new UserResponse();

        // Copy the properties from the User to the UserResponse
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }
}
