package com.example.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


@EnableOpenApi
@Configuration
public class SwaggerConfig {

    private ApiInfo info() {
        ApiInfo info = new ApiInfoBuilder().title("swagger")
                .description("api document")
                .version("v1.0.0")
                .build();
        return info;
    }

    private List<RequestParameter> parameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        RequestParameter token = new RequestParameterBuilder().name("token")
                .in(ParameterType.HEADER)
                .example(new ExampleBuilder().value("token").build())
                .build();

        parameters.add(token);
        return parameters;
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(info())
                .globalRequestParameters(parameters());
    }
}
