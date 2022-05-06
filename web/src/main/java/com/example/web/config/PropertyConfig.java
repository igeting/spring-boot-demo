package com.example.web.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Other other;

    @Data
    @Component
    @ConfigurationProperties(prefix = "test.other")
    public class Other {
        private String address;
    }
}
