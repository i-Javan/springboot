package com.movebrick.datastructure.dubbo.module.service;

import java.util.List;

import com.movebrick.datastructure.dubbo.module.bean.User;
import com.movebrick.datastructure.dubbo.module.api.DemoService;

public interface DubboService extends DemoService{
	
	List<User> getList();
	
	User getById(String id);
	
}
