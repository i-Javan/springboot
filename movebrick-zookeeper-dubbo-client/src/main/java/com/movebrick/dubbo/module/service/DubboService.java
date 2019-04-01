package com.movebrick.dubbo.module.service;

import java.util.List;

import com.movebrick.dubbo.module.api.DemoService;
import com.movebrick.dubbo.module.bean.User;

public interface DubboService extends DemoService{
	
	List<User> getList();
	
	User getById(String id);
	
}
