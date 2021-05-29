package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootTest
class ApplicationTests {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserService userService;

    @Test
    void TestRequest() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://www.baidu.com", null, String.class);
        log.info("res:{}", res);
    }

    @Test
    void TestUser() {
        int count = userService.userCount();
        Assert.isTrue(count > 0, "user is null");
        List<User> users = userService.userList();
        log.info("user list:{}", users);
        Gson gson = new Gson();
        String str = gson.toJson(users);
        log.info(str);
    }

}
