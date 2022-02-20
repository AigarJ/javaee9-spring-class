package com.sda.javaee9spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // class who is able to provide many Spring beans
public class RestTemplateConfig {

    @Bean // this method is producing new bean
    public RestTemplate restTemplate(){
        return new RestTemplate();

    }
}
