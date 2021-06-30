package com.example.nsq;

import com.example.nsq.consume.NsqConsume;
import com.example.nsq.produce.NsqProduce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NsqApplicationTests {
    @Autowired
    NsqProduce produce;

    @Autowired
    NsqConsume consume;

    @Test
    void TestNsq() {
        produce.produce("hello lulu");
        consume.consume(message -> {
            byte msg[] = message.getMessage();
            String result = new String(msg);
            System.out.println(result);
            message.finished();
        });
    }
}
