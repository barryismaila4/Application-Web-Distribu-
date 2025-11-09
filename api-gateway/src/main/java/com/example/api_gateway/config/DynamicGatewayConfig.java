package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicGatewayConfig {

    @Bean
    public RouteLocator dynamicGatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Candidat", r -> r.path("/api/candidats/**")
                        .uri("lb://candidat-service"))  // lb = load balancing via Eureka
                .route("Job", r -> r.path("/api/jobs/**")
                        .uri("lb://job-service"))       // lb = load balancing via Eureka
                .build();
    }
}