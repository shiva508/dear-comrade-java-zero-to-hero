package com.comrade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DCConfig {

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
