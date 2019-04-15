package com.movebrick.datastructure.dubbo.module.controller;

import java.util.List;

import com.movebrick.datastructure.dubbo.module.bean.User;
import com.movebrick.datastructure.dubbo.module.service.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/pc/dobbe")
public class DubboController {
	@Reference(version = "1.0.0")
	private DubboService dubboService;

	@GetMapping("/get")
	public List<User> get() {
		return dubboService.getList();
	}

	@GetMapping("/getById")
	public User getById() {
		return dubboService.getById("1");
	}
	@GetMapping("/sayHello")
	public String sayHello() {
		return dubboService.sayHello("SayHello!");
	}
	
}
