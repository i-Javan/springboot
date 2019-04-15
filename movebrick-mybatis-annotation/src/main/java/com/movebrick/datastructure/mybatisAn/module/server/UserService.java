package com.movebrick.datastructure.mybatisAn.module.server;

import java.util.List;

import com.movebrick.datastructure.mybatisAn.module.bean.User;


public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
}
