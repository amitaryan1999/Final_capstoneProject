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
				.route("AdminId", r-> r.path("/api/property**").uri("http://localhost/8085"))
				.route("CarouselId", r-> r.path("/carousel/**").uri("http://localhost/8088"))
				.route("ConsultantId", r-> r.path("/consult/**").uri("http://localhost/8089"))
				.route("ScheduleTourId", r-> r.path("/tour/**").uri("http://localhost/8084"))
				.route("Featured", r-> r.path("/api/**").uri("http://localhost/8086"))
				.route("Agent", r-> r.path("/api/agent/**").uri("http://localhost/8082"))

				.build();
	}
}
