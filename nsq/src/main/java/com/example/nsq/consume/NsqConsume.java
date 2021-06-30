package com.example.nsq.consume;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.callbacks.NSQMessageCallback;
import com.github.brainlag.nsq.lookup.NSQLookup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NsqConsume {
    @Value("${nsq.topic}")
    private String topic;
    @Value("${nsq.channel}")
    private String channel;

    @Autowired
    private NSQLookup nsqLookup;

    public void consume(NSQMessageCallback handler) {
        //handler
        /*
            message -> {
                byte msg[] = message.getMessage();
                result = new String(msg);
                message.finished();
            }
         */
        try {
            NSQConsumer consumer = new NSQConsumer(nsqLookup, topic, channel, handler);
            consumer.start();

            Thread.sleep(3000);

            consumer.setExecutor(command -> {
                //todo
            });
        } catch (Exception e) {
            log.error("NsqConsume consume error", e);
        }
    }
}
