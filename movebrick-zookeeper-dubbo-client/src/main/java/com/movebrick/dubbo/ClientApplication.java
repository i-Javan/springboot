package com.movebrick.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.movebrick.dubbo.module.service.DubboClientService;

@EnableDubbo
@SpringBootApplication
public class ClientApplication {	

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        DubboClientService dubboClientService = run.getBean(DubboClientService.class);
        System.err.println("初始调用");
        System.err.println(dubboClientService.get());
    }
    
}

