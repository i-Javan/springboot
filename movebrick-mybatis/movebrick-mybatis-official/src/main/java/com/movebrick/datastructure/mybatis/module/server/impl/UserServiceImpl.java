package com.movebrick.datastructure.mybatis.module.server.impl;

import java.util.List;

import com.movebrick.datastructure.mybatis.module.mapper.UserMapper;
import com.movebrick.datastructure.mybatis.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movebrick.datastructure.mybatis.module.bean.User;


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
		return userMapper.getList();
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

}
