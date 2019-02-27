package com.movebrick.dubbo.module.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.movebrick.dubbo.module.bean.User;
import com.movebrick.dubbo.module.service.DubboService;

@RestController
@RequestMapping("/pc/dobbe")
public class DubboController {
	@Reference(version = "1.0.1")
	private DubboService dubboService;

	@GetMapping("/get")
	public List<User> get() {
		return dubboService.getList();
	}

	@GetMapping("/getById")
	public User getById() {
		return dubboService.getById("1");
	}

}
