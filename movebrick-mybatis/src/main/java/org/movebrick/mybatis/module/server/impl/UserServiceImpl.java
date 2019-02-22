package org.movebrick.mybatis.module.server.impl;

import java.util.List;

import org.movebrick.mybatis.module.bean.User;
import org.movebrick.mybatis.module.mapper.UserMapper;
import org.movebrick.mybatis.module.server.UserService;
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
		return userMapper.getList();
	}

}
