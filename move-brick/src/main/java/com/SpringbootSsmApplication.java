package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)

@SpringBootApplication
//@EnableAsync
//@EnableScheduling
//@EntityScan(basePackages="com.movebrick.framework")
@MapperScan({ "com.movebrick.module.mapper", "com.movebrick.framework.base.mapper" })
public class SpringbootSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSsmApplication.class, args);
		//ZkClient zkClient = context.getBean(ZkClient.class);
		//zkClient.register();
	}
}
