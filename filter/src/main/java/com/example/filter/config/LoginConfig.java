package com.example.filter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 登录配置
 * 需要添加登录拦截器 LoginInterceptor
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());

        interceptor.addPathPatterns("/**");

        interceptor.excludePathPatterns("/**/login");
        interceptor.excludePathPatterns("/**/*.html");
        interceptor.excludePathPatterns("/**/*.js");
        interceptor.excludePathPatterns("/**/*.css");

        interceptor.excludePathPatterns("/swagger-ui/**");
        interceptor.excludePathPatterns("/swagger-resources/**");
        interceptor.excludePathPatterns("/v3/**");
    }
}
