package com.movebrick.datastructure.dubbo.module.service;

import java.util.List;

import com.movebrick.datastructure.dubbo.module.bean.User;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class DubboClientService {
	
	@Reference(version = "1.0.0")
	DubboService dubboService;
	
	public List<User> get() {
		System.out.println(dubboService);
		return dubboService.getList();
	}

	public User getById() {
		return dubboService.getById("1");
	}
}
