package com.example.nsq.produce;

import com.sproutsocial.nsq.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NsqPublisher {
    @Value("${nsq.topic}")
    private String topic;
    @Value("${nsq.channel}")
    private String channel;

    @Autowired
    Publisher publisher;

    public void publish(String message) {
        try {
            publisher.publish(topic, message.getBytes());
        } catch (Exception e) {
            log.error("NsqPublisher publish error", e);
        }
    }
}
