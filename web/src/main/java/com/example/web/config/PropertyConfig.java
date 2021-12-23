package com.example.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:other.yml"}, factory = YamlConfigFactory.class)
@ConfigurationProperties(prefix = "test")
public class PropertyConfig {
    private String name;
    private int age;
}
