package com.movebrick.datastructure.dubbo.module.service.impl;

import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.movebrick.datastructure.dubbo.module.api.DemoService;
import com.movebrick.datastructure.dubbo.module.bean.User;
import com.movebrick.datastructure.dubbo.module.service.DubboService;

@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService, DemoService {

	public List<User> getList() {
		return Arrays.asList(new User[]{new User("1","小红","18","18@qq.com"),new User("1","❤","17","17@qq.com")});
	}

	public User getById(String id) {
		return new User("1","小红","18","18@qq.com");
	}

	@Override
	public String sayHello(String name) {
		return DemoService.class.getPackage().toString()+"调用成功!:"+name;
	}

}
