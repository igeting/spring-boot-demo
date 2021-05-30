package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    void TestRequest() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://www.baidu.com", null, String.class);
        System.out.println(res);
    }

    @Autowired
    private UserService userService;

    @Test
    void TestUser() {
        int count = userService.userCount();
        System.out.println(count);
        List<User> users = userService.userList();
        System.out.println(users.toString());
        Gson gson = new Gson();
        String str = gson.toJson(users);
        System.out.println(str);
    }

    @Autowired
    private Gson gson;

    @Test
    void TestGson() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        //对象转字符串
        System.out.println(gson.toJson(user));
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        System.out.println(gson.toJson(list));

        //字符串转对象
        User u = gson.fromJson("{\"name\":\"jack\",\"pass\":\"123456\"}", User.class);
        System.out.println(u.toString());
        List<User> us = gson.fromJson("[{\"name\":\"jack\",\"pass\":\"123456\"},{\"name\":\"jack\",\"pass\":\"123456\"},{\"name\":\"jack\",\"pass\":\"123456\"}]",
                new TypeToken<List<User>>() {
                }.getType());
        System.out.println(us.toString());
    }

    @Value("${env}")
    private String env;

    @Value("${other}")
    private String other;

    @Test
    void TestConfig() {
        System.out.println(env);
        System.out.println(other);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void TestDatasource() {
        System.out.println(jdbcTemplate.toString());
        try {
            DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
