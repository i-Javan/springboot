package com.movebrick.datastructure.mybatisAn.module.server.impl;

import java.util.List;

import com.movebrick.datastructure.mybatisAn.module.bean.User;
import com.movebrick.datastructure.mybatisAn.module.mapper.UserMapper;
import com.movebrick.datastructure.mybatisAn.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl<ID> implements UserService<ID> {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String login(ID id) {
		return null;
	}

	@Override
	public List<User> getList() {
		return userMapper.findAll();
	}

}