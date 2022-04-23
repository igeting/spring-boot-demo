package com.example.core;

import com.example.core.config.ObjectConfig;
import com.example.core.entity.UserInfo;
import com.example.core.mapper.UserMapper;
import com.example.core.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootTest
class CoreApplicationTest {
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
        int count = userService.getUserCount();
        System.out.println(count);
        UserInfo u = userService.getUser(1);
        System.out.println(u);
        List<UserInfo> users = userService.getUsers();
        System.out.println(users.toString());
        Gson gson = new Gson();
        String str = gson.toJson(users);
        System.out.println(str);
    }

    @Autowired
    private Gson gson;

    @Test
    void TestGson() {
        UserInfo user = new UserInfo();
        user.setUsername("jack");
        user.setPassword("123456");
        System.out.println(gson.toJson(user));

        List<UserInfo> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        System.out.println(gson.toJson(list));

        UserInfo u = gson.fromJson("{\"name\":\"jack\",\"pass\":\"123456\"}", UserInfo.class);
        System.out.println(u.toString());
        List<UserInfo> us = gson.fromJson("[{\"name\":\"jack\",\"pass\":\"123456\"},{\"name\":\"jack\",\"pass\":\"123456\"},{\"name\":\"jack\",\"pass\":\"123456\"}]",
                new TypeToken<List<UserInfo>>() {
                }.getType());
        System.out.println(us.toString());
    }

    @Value("${other}")
    private String other;

    @Test
    void TestConfig() {
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

    @Autowired
    UserMapper userMapper;

    @Test
    void TestDao() {
        /*User u = new User();
        u.setUsername("test");
        u.setPassword("123456");
        User save = userMapper.save(u);
        System.out.println(save.toString());*/
        List<UserInfo> list = userMapper.allUsers();
        System.out.println(list);
    }

    @Autowired
    EntityManager entityManager;

    @Test
    void TestEntityManager() {
        String sql = "select * from user";
        Query query = entityManager.createNativeQuery(sql);
        List<UserInfo> result = query.getResultList();
        System.out.println(gson.toJson(result));
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void TestRedis() {
        redisTemplate.opsForValue().set("name", "jack");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Autowired
    ObjectConfig objectConfig;

    @Test
    void TestPropertiesConfig() {
        String id = objectConfig.getId();
        String pro1 = objectConfig.getPro1();
        String pro2 = objectConfig.getPro2();
        System.out.println(String.format("id:%s, pro1:%s, pro2:%s", id, pro1, pro2));
        String name = objectConfig.getUser().getName();
        int age = objectConfig.getUser().getAge();
        System.out.println(String.format("name:%s, age:%d\n", name, age));
    }

}
