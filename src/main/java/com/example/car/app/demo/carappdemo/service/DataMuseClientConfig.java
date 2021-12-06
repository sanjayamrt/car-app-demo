package com.example.car.app.demo.carappdemo.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DataMuseClientConfig {

    @Bean
    RestTemplate getDataMuseRESTClient(RestTemplateBuilder builder ) {
        return builder.build();
    }
}
