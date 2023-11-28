package com.example.deliverypetproject.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi userGroupController(){
        return GroupedOpenApi.builder()
                .group("User Controller")
                .pathsToMatch("/api/v1/users/**")
                .build();
    }

    @Bean GroupedOpenApi actuatorGroupController(){
        return GroupedOpenApi.builder()
                .group("Actuator Controller")
                .pathsToMatch("/api/actuator/**")
                .build();
    }
}
