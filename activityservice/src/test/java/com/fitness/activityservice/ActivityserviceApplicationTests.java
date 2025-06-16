package com.fitness.activityservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivityserviceApplicationTests {

  @Autowired
  private ApplicationContext context;

  @Test
  void contextLoads() {
    assertThat(context).isNotNull();
  }

}
