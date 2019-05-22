package org.movebrick.mybatis.module.server;

import java.util.List;

import org.movebrick.mybatis.module.bean.User;

public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
}
