package com.movebrick.module.service;

import java.util.List;

import com.movebrick.module.bean.User;


public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
}
