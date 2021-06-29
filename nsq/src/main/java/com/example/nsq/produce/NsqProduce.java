package com.example.nsq.produce;

import com.github.brainlag.nsq.NSQProducer;

public class NsqProduce {
    public static void nsqProduce() {
        NSQProducer producer = new NSQProducer();
        producer.addAddress("127.0.0.1", 4150).start();
        try {
            producer.produce("test", "hello world".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        nsqProduce();
    }
}
