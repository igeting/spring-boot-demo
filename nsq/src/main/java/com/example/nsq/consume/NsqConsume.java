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

    public void consume(NSQMessageCallback callback) {
        //callback
        /*
            message -> {
                byte msg[] = message.getMessage();
                result = new String(msg);
                message.finished();
            }
         */
        NSQConsumer consumer = new NSQConsumer(nsqLookup, topic, channel, callback);
        consumer.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.setExecutor(command -> {
            //todo
        });
    }
}
