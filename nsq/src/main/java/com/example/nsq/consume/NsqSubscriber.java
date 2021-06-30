package com.example.nsq.consume;

import com.sproutsocial.nsq.MessageHandler;
import com.sproutsocial.nsq.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NsqSubscriber {
    @Value("${nsq.topic}")
    private String topic;
    @Value("${nsq.channel}")
    private String channel;

    @Autowired
    Subscriber subscriber;

    public void subscribe(MessageHandler handler) {
        //handler
        /*
            message -> {
                byte msg[] = message.getData();
                String result = new String(msg);
                System.out.println(result);
                message.finish();
            }
         */
        try {
            subscriber.subscribe(topic, channel, handler);
        } catch (Exception e) {
            log.error("NsqSubscriber subscribe error", e);
        }
    }
}
