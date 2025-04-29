package com.fitness.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponse register(RegisterRequest requestBody) {
        if (userRepository.existsByEmail(requestBody.getEmail())) {
            throw new RuntimeException("User with email: " + requestBody.getEmail() + " already exists!!");
        }

        User user = new User();
        user.setEmail(requestBody.getEmail());
        user.setPassword(requestBody.getPassword());
        user.setFirstName(requestBody.getFirstName());
        user.setLastName(requestBody.getLastName());

        // save to the db
        User savedUser = userRepository.save(user);

        return UserResponse.from(savedUser);
    }

    public UserResponse getUserProfile(String userId) {
        User searchedUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found"));

        return UserResponse.from(searchedUser);
    }

}
