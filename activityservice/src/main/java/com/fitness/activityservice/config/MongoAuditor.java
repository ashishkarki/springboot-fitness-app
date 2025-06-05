package com.fitness.activityservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * @EnableMongoAuditing: Enables auditing for MongoDB, which allows for
 *                       automatic
 *                       creation and update
 *                       dates to be set on entities annotated
 *                       with @CreatedDate and @LastModifiedDate
 */
@Configuration
@EnableMongoAuditing
public class MongoAuditor {

}
