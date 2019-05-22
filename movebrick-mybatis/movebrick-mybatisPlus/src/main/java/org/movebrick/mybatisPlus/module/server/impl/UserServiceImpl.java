package org.movebrick.mybatisPlus.module.server.impl;

import java.util.List;

import org.movebrick.mybatisPlus.module.bean.User;
import org.movebrick.mybatisPlus.module.mapper.UserMapper;
import org.movebrick.mybatisPlus.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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
