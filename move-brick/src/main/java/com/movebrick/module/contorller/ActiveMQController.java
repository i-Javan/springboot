package com.movebrick.module.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pc/activemq")
public class ActiveMQController {
	@Autowired
	private Environment env;

	@RequestMapping("/helloSpringBoot")
	public String hello() {
		return "hello springboot";
	}

	@RequestMapping("/info")
	public String info() {
		return "info:" + env.getProperty("url");
	}
}
