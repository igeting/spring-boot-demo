package com.example.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PropertiesConfig {
    private static final String SPRING_CONFIG_LOCATION = "spring.config.location";

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        final List<Resource> resourceList = new ArrayList<>();
        if (System.getProperty(SPRING_CONFIG_LOCATION) != null) {
            String configFilePath = System.getProperty(SPRING_CONFIG_LOCATION);
            String[] configFiles = configFilePath.split(",|;");

            for (String configFile : configFiles) {
                if (configFile.startsWith("file:")) {
                    resourceList.add(new FileSystemResource(configFile));
                } else {
                    resourceList.add(new ClassPathResource(configFile));
                }
            }

        } else {
            resourceList.add(new ClassPathResource("application.properties"));
        }

        ppc.setLocations(resourceList.toArray(new Resource[]{}));
        return ppc;
    }
}
