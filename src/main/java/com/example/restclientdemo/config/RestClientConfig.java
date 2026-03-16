package com.example.restclientdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    RestClient jsonPlaceholderRestClient(
            RestClient.Builder builder,
            @Value("${client.jsonplaceholder.base-url}") String baseUrl) {
        return builder
                .baseUrl(baseUrl)
                .build();
    }
}
