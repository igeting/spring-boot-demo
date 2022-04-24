package com.example.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Configuration
@EnableScheduling
@EnableAsync
public class ScheduleConfig implements SchedulingConfigurer {

    /**
     * 定时任务（用注解方式默认为单线程）
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        System.out.println("schedule task ...");
    }

    /**
     * 定时任务（用接口方式可以实现多线程）
     *
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> {
                    System.out.println("trigger task ...");
                },
                ctx -> {
                    String cron = "0/5 * * * * ?";
                    return new CronTrigger(cron).nextExecutionTime(ctx);
                });
    }

    /**
     * 多线程定时任务
     */
    @Async
    @Scheduled(fixedDelay = 1000)
    public void asyncTask() {
        System.out.println("async task ...");
    }
}
