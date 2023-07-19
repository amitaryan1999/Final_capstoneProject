package com.api;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;


import java.util.stream.Collectors;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApiGatewayMsApplication {

    @Configuration
    public class CustomHttpMessageConvertersConfiguration extends HttpMessageConvertersAutoConfiguration {
        @Bean
        @ConditionalOnMissingBean
        public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
            return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayMsApplication.class, args);
    }
}
