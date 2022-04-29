package com.example.web.config;

import com.google.gson.*;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import springfox.documentation.spring.web.json.Json;

import java.lang.reflect.Type;

@Configuration
public class MessageConfig implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json src, Type typeOfSrc, JsonSerializationContext context) {
        return JsonParser.parseString(src.value());
    }

    @Bean
    public HttpMessageConverters httpMessageConverters() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Json.class, new MessageConfig())
                .create());
        return new HttpMessageConverters(converter);
    }
}
