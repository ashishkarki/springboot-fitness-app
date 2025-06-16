package com.fitness.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SecurityConfig {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    log.debug("Creating BCryptPasswordEncoder bean from SecurityConfig (core module)");
    return new BCryptPasswordEncoder();
  }
}
