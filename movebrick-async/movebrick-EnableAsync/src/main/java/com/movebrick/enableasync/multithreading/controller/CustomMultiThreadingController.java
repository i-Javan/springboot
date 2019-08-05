package com.movebrick.enableasync.multithreading.controller;

import com.movebrick.enableasync.multithreading.service.CustomMultiThreadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CustomMultiThreadingController
 * @Author 李嘉伟
 * @Date 2019/7/28 14:00
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/multithreading")
public class CustomMultiThreadingController {
    @Autowired
    private CustomMultiThreadingService customMultiThreadingService;

    @RequestMapping(value = "/dotask")
    public String doTask() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            customMultiThreadingService.executeAysncTask1(i);
            customMultiThreadingService.executeAsyncTask2(i);
        }
        return "success";
    }

}
