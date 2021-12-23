package com.example.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "one")
//@PropertySource(value = {"classpath:object-config.properties"}, encoding = "UTF-8")
@PropertySource(value = {"classpath:object-config.yml"}, factory = YamlConfigFactory.class, encoding = "UTF-8")
public class ObjectConfig {
    private String id;
    private String pro1;
    private String pro2;
    private User user;

    @Data
    public static class User {
        private String name;
        private int age;
    }
}
