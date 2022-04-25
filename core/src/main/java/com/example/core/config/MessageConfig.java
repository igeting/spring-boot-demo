package com.example.core.config;

import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
public class MessageConfig {

    @Bean
    public HttpMessageConverters httpMessageConverters() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create());
        return new HttpMessageConverters(converter);
    }

}
