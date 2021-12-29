package com.study.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator custRouteLocator (RouteLocatorBuilder builder){
        return builder.routes().route("route1",r -> r.path("/").uri("http://192.168.1.160/")).build();
    }
}
