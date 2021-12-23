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

    @Bean(name = "newDataSource")
    public DataSource dataSource() {
        //DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName(Driver.class.getName());
        //dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        //dataSource.setUrl("postgres");
        //dataSource.setPassword("123456");
        //return dataSource;

        return DataSourceBuilder.create()
                .driverClassName(Driver.class.getName())
                .url("jdbc:postgresql://localhost:5432/test")
                .username("postgres")
                .password("123456").build();
    }

}
