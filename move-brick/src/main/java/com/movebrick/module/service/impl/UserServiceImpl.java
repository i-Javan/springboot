package com.movebrick.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movebrick.module.bean.User;
import com.movebrick.module.mapper.UserMapper;
import com.movebrick.module.service.UserService;

@Service
@Transactional(readOnly=true,propagation = Propagation.REQUIRED)
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
