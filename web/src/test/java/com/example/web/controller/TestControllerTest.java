package com.example.web.controller;

import com.example.web.to.UserTO;
import com.example.web.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Transactional 如果操作了数据库会回滚，避免修改数据库
 * @Rollback(value = false) 可以设置不回滚
 */
@Rollback(value = true)
@Transactional
@SpringBootTest
class TestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new TestController()
        ).build();
    }

    @Test
    void testRequest() throws Exception {
        int status = mockMvc.perform(
                MockMvcRequestBuilders.get("/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("name", "lulu"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

    @Test
    void updateNameTest() {
        UserTO user = new UserTO();
        user.setUsername("lulu");
        userService.modUser(1l, user);
    }
}