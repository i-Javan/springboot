package com.enableasync;

import com.movebrick.enableasync.multithreading.CustomMultiThreadingConfig;
import com.movebrick.enableasync.multithreading.service.CustomMultiThreadingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TesrController
 * @Author 李嘉伟
 * @Date 2019/7/29 11:55
 * @Version 1.0
 * @Description TODO
 */
public class TesrController {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomMultiThreadingConfig.class);

        CustomMultiThreadingService testService2 = context.getBean(CustomMultiThreadingService.class);
        for (int i = 0; i < 10; i++) {
            testService2.executeAysncTask1(i);
            testService2.executeAsyncTask2(i);
        }
        context.close();

    }
}
