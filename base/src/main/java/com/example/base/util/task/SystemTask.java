package com.example.base.util.task;

import java.util.concurrent.*;

public class SystemTask {
    //系统线程池
    public static Executor TASK_POOL = Executors.newCachedThreadPool();

    /**
     * 添加任务
     *
     * @param task
     */
    public static void addTask(Runnable task) {
        TASK_POOL.execute(task);
    }

    /**
     * 添加异步任务
     *
     * @param call
     * @return
     */
    public static Future addTaskAsync(Callable call) {
        FutureTask task = new FutureTask(call);
        TASK_POOL.execute(task);
        return task;
    }

}
