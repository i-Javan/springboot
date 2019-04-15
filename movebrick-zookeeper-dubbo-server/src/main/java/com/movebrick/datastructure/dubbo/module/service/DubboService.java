package com.movebrick.datastructure.dubbo.module.service;

import java.util.List;

import com.movebrick.datastructure.dubbo.module.bean.User;

public interface DubboService {
	
	List<User> getList();
	
	User getById(String id);
	
}
