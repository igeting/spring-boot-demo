package com.example.demo.config;

import com.google.gson.Gson;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@MapperScan(value = {"com.example.demo.mapper"})
@Configuration
public class ApplicationConfig {
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(20 * 1000);
        factory.setConnectTimeout(10 * 60 * 1000);
        return factory;
    }

    @Bean
    RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    Gson gson() {
        return new Gson();
    }

}
