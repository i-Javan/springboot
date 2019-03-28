package org.movebrick.mybatisPlus.module.server;

import java.util.List;

import org.movebrick.mybatisPlus.module.bean.User;



public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
}
