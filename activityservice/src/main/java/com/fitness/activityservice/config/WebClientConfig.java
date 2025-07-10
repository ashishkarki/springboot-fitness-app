package com.fitness.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient in ActivityService, which is used to
 * make HTTP requests to other microservices specially the UserService and
 * hence connecting a user to their activities.
 */
@Configuration
public class WebClientConfig {

  /**
   * Creates and returns a WebClient.Builder for constructing WebClient instances.
   * This method provides a configurable builder that can be used to create
   * WebClient instances with custom configurations.
   *
   * The LoadBalanced annotation is used to enable client-side load balancing
   * between multiple instances of the UserService microservice.
   * This allows the ActivityService to automatically distribute requests across
   * multiple instances, ensuring efficient and balanced load distribution.
   *
   * @return a WebClient.Builder ready for further configuration
   */
  @Bean
  @LoadBalanced
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

  /**
   * Creates a WebClient bean configured with a base URL for the UserService.
   * This WebClient is used to make HTTP requests to the UserService
   * microservice.
   *
   * @param webClientBuilder a builder for creating WebClient instances.
   * @return a WebClient configured with the UserService base URL.
   */

  @Bean
  public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
    return webClientBuilder.baseUrl("http://userservice").build();
  }
}
