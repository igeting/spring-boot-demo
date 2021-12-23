package com.example.web.config;

import org.postgresql.Driver;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
//@ComponentScan(basePackages = {"com.example.web.config"})
public class SystemConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    /*
    @Bean(name = "dataSource1")
    public DataSource dataSource1() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName(Driver.class.getName());
        builder.url("jdbc:postgresql://localhost:5432/test");
        builder.username("postgres");
        builder.password("123456");
        return builder.build();
    }

    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        dataSource.setUrl("postgres");
        dataSource.setPassword("123456");
        return dataSource;
    }
    */
}
