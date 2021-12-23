package com.example.web.config;

import lombok.extern.slf4j.Slf4j;
import org.postgresql.Driver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@EnableAsync
@Configuration
//@ComponentScan(basePackages = {"com.example.web.config"})
public class SystemConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean(name = "taskPool")
    public Executor executor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(), new CustomizableThreadFactory("task-pool-"));
        return executor;
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
