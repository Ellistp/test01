package com.yhub.web.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/8
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    /**
     * 核心池大小
     */
    private int corePoolSize = 5;

    /**
     * 线程池最大能接受的线程数量
     */
    private int maximumPoolSize = 200;

    /**
     * 当当前线程池中的线程数量大于 corePoolSize 小于 maximumPoolSize 时,
     * 线程的空闲时间 keepAliveTIme ,超过这个时间, 线程将被终止, 直到线程池中的
     * 线程数量不大于 corePoolSize
     */
    private Long keepAliveTime = 0L;

    /**
     * 时间单位 秒
     */
    private TimeUnit timeUnit = TimeUnit.SECONDS;

    /**
     * 数组缓存队列, 默认队列数为5
     */
    private BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

    /**
     * 实例化线程池 对象
     */
    ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public ExecutorService taskExecutor() {
        return threadPoolExecutor;
    }
}
