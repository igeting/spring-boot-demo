package com.example.web;

import com.example.web.config.SystemConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTest {


    @Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SystemConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
