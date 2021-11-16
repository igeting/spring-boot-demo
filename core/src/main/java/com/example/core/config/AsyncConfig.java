package com.example.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    /**
     * 线程池
     *
     * @return
     * @Resource("doSomethingExecutor") private Executor executor;
     * executor.execute(() -> {});
     * @Async("doSomethingExecutor") public void task(){}
     */
    @Bean(name = "doSomethingExecutor")
    public Executor doSomethingExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程：线程池创建时初始化的线程数
        executor.setCorePoolSize(10);
        //最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(20);
        //缓冲队列：用来缓冲执行任务的队列
        executor.setQueueCapacity(500);
        //允许线程的空闲时间（秒），当超过了核心线程之外的线程在达到空闲时间后会被销毁
        executor.setKeepAliveSeconds(60);
        //线程池名称前缀
        executor.setThreadNamePrefix("do-something-");
        //缓冲队列满了之后的拒绝策略：由调用线程处理（一般是主线程）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }

}
