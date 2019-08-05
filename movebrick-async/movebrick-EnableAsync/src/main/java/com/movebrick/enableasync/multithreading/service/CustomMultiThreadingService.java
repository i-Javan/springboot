package com.movebrick.enableasync.multithreading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName CustomMultiThreadingService
 * @Author 李嘉伟
 * @Date 2019/7/28 13:59
 * @Version 1.0
 * @Description TODO
 */
@Service
public class CustomMultiThreadingService {
    private Logger logger = LoggerFactory.getLogger(CustomMultiThreadingService.class);

    /**
     * @param i
     * @Description:通过@Async注解表明该方法是一个异步方法， 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAysncTask1
     * @Date: 2018年9月21日 下午2:54:32
     * @Author: OnlyMate
     * @Throws
     */
    @Async
    public void executeAysncTask1(Integer i) throws InterruptedException {
        logger.info("CustomMultiThreadingService ==> executeAysncTask1 method: 执行异步任务{} ", i);
        Thread.sleep(10000);

    }

    /**
     * @param i
     * @Description:通过@Async注解表明该方法是一个异步方法， 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask2
     * @Date: 2018年9月21日 下午2:55:04
     * @Author: OnlyMate
     * @Throws
     */
    @Async
    public void executeAsyncTask2(Integer i) throws InterruptedException {
        logger.info("CustomMultiThreadingService ==> executeAsyncTask2 method: 执行异步任务{} ", i);
        Thread.sleep(10000);
    }
}
