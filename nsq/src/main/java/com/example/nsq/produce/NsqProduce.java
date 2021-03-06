package com.example.nsq.produce;

import com.github.brainlag.nsq.NSQProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class NsqProduce {
    @Value("${nsq.topic}")
    private String topic;
    @Value("${nsq.channel}")
    private String channel;

    @Autowired
    private NSQProducer nsqProducer;

    @PostConstruct
    public void init() {
        nsqProducer.start();
    }

    public void produce(String message) {
        try {
            nsqProducer.produce(topic, message.getBytes());
        } catch (Exception e) {
            log.error("NsqProduce nsqProduce error", e);
        }
    }
}
