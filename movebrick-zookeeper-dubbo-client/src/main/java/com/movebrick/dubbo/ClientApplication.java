package com.movebrick.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.movebrick.dubbo.module.service.DubboClientService;


/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
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

