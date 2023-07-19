package com.api.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutingConfig {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
            // REGISTER
            .route("REGISTER-ROUTE", r -> r.path("/register/**").uri("http://localhost:8082"))
            // AGENT
            .route("AGENT-ROUTE", r-> r.path("/agent/**").uri("http://localhost:8084"))
            // FEATUREDPROP
            .route("FEATUREDPROP-ROUTE", r-> r.path("/featured/**").uri("http://localhost:8086"))
            // ADMINPROP
            .route("ADMINPROP-ROUTE", r-> r.path("/admin/**").uri("http://localhost:8085"))
            // CAROUSL
            .route("CAROUSL-ROUTE", r-> r.path("/carousel/**").uri("http://localhost:8088"))
            // CONSULTANT
            .route("CONSULTATION-ROUTE", r-> r.path("/consult/**").uri("http://localhost:8089"))
            // SCHEDULED
            .route("SCHEDULED-ROUTE", r-> r.path("/schtour/**").uri("http://localhost:8087"))
            // GATEWAYAUTHLOG
//            .route("GATEWAYROUTE", r-> r.path("/path/**").uri("http://localhost:8089"))
            // .route("capauthlog-ROUTE", r-> r.path("/path/**").uri("http://localhost:8083"))
            .build();
    }
}
