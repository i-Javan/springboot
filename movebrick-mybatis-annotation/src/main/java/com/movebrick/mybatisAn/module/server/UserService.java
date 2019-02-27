package com.movebrick.mybatisAn.module.server;

import java.util.List;

import com.movebrick.mybatisAn.module.bean.User;


public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
}
