package com.fitness.userservice.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.exception.UserAlreadyExistsException;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  /**
   * Registers a new user in the system.
   *
   * @param requestBody The registration details of the user to be created
   * @return UserResponse containing the details of the newly created user
   * @throws RuntimeException if a user with the provided email already exists
   */
  public UserResponse register(RegisterRequest requestBody) {
    if (userRepository.existsByEmail(requestBody.getEmail())) {
      throw new UserAlreadyExistsException("User with email: " + requestBody.getEmail() + " already exists!!");
    }

    User user = new User();
    user.setEmail(requestBody.getEmail());
    user.setPassword(passwordEncoder.encode(requestBody.getPassword())); // encrypt the password
    user.setFirstName(requestBody.getFirstName());
    user.setLastName(requestBody.getLastName());

    // save to the db
    User savedUser = userRepository.save(user);

    // return the response as UserResponse object
    return UserResponse.from(savedUser);
  }

  public UserResponse getUserProfile(String userId) {
    User searchedUser = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User with id: " + userId + " not found"));

    return UserResponse.from(searchedUser);
  }

}
