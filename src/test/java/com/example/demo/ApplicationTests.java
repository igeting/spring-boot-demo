package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootTest
class ApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Test
    void contextLoads() {
        log.info("hello world");
        ResponseEntity<String> res = restTemplate.getForEntity("http://www.baidu.com", null, String.class);
        log.info("res:{}", res);
    }

}
