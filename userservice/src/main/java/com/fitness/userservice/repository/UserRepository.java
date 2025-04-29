package com.fitness.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitness.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * checks if a user with the specified email already exists in the database, and
     * returns true if they do, and false otherwise
     *
     * @param email the email to check
     * @return true if the user exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * finds a user in the database by their email
     *
     * @param email the email to search for
     * @return the User object if it's found, null otherwise
     */
    User findByEmail(String email);
}
