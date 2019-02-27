package com.movebrick.dubbo.module.service;

import java.util.List;

import com.movebrick.dubbo.module.bean.User;

public interface DubboService {
	
	List<User> getList();
	
	User getById(String id);
	
}
