package com.example.nsq.consume;

import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

public class NsqConsume {
    public static void nsqConsume() {
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress("127.0.0.1", 4161);
        NSQConsumer consumer = new NSQConsumer(lookup, "test", "nsq_to_file", message -> {
            byte b[] = message.getMessage();
            String s = new String(b);
            System.out.println(s);
            message.finished();
        });
        consumer.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumer.setExecutor(command -> {
            //todo
        });
    }

    public static void main(String[] args) {
        nsqConsume();
    }
}
