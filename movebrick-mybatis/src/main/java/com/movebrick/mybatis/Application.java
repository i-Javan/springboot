package com.movebrick.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapper 接口类扫描包配置
@MapperScan({"com.movebrick.mybatis.module.mapper","com.movebrick.mybatis.generator.mapper"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}