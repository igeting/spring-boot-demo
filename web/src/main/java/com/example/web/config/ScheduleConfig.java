package com.example.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableAsync
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Async(value = "taskPool")
    @Scheduled(fixedDelay = 3000)
    public void task() {
        log.info("system task:{}", Thread.currentThread().getName());
    }
}
