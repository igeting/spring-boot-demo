package com.example.common;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

public class CommonApplicationTest {

    @Test
    public void test1() {
        String name = "zhangsan";
        System.out.println(name);
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        while(true) {
            System.out.println(obj);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
