package com.movebrick.datastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/pc/dataStruture")
public class CounterController {

    private static AtomicInteger count = new AtomicInteger(0);

    @GetMapping("exec1")
    public String exec() {
        System.err.println(count.get());
        if (count.get() >= 5) {
            System.err.println("请求用户过多，请稍后在试！" + System.currentTimeMillis() / 1000);
            return "false";
        } else {
            count.incrementAndGet();
            try {
                //处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                System.err.println("--" + System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count.decrementAndGet();
            }
            return "true";
        }
    }
}
