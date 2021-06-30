package com.example.nsq.config;

import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NsqConfig {
    @Value("${nsq.lookup.host}")
    private String lookupHost;
    @Value("${nsq.lookup.port}")
    private int lookupPort;

    @Value("${nsq.nsqd.host}")
    private String nsqdHost;
    @Value("${nsq.nsqd.port}")
    private int nsqdPort;

    @Bean
    public NSQLookup nsqLookup() {
        NSQLookup lookup = new DefaultNSQLookup();
        lookup.addLookupAddress(lookupHost, lookupPort);
        return lookup;
    }

    @Bean
    public NSQProducer nsqProducer() {
        NSQProducer producer = new NSQProducer();
        producer.addAddress(nsqdHost, nsqdPort);
        return producer;
    }
}
