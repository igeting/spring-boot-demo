package com.example.common;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class CommonApplicationTest {

    @Test
    public void TestFastJson() {
        String name = "lulu";
        log.info(name);
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        for (int i = 0; i < 3; i++) {
            log.info("{}", obj);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void TestStream() {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(x -> x * x).forEach(System.out::println);
    }

}
