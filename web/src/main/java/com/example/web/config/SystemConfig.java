package com.example.web.config;

import org.postgresql.Driver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
//@ComponentScan(basePackages = {"com.example.web.config"})
public class SystemConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean(name = "newDataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName(Driver.class.getName())
                .url("jdbc:postgresql://localhost:5432/test")
                .username("postgres")
                .password("123456").build();
    }

}
