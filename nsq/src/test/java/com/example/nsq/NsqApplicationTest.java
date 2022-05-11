package com.example.nsq;

import com.example.nsq.consume.NsqConsume;
import com.example.nsq.consume.NsqSubscriber;
import com.example.nsq.produce.NsqProduce;
import com.example.nsq.produce.NsqPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NsqApplicationTest {
    @Autowired
    NsqPublisher publisher;
    @Autowired
    NsqSubscriber subscriber;
    @Autowired
    NsqProduce produce;
    @Autowired
    NsqConsume consume;

    @Test
    void TestNsqJ() {
        publisher.publish("hello world");
        subscriber.subscribe(message -> {
            byte[] msg = message.getData();
            String result = new String(msg);
            System.out.println(result);
            message.finish();
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestNsqClient() {
        produce.produce("hello world");
        consume.consume(message -> {
            byte[] msg = message.getMessage();
            String result = new String(msg);
            System.out.println(result);
            message.finished();
        });
    }
}
