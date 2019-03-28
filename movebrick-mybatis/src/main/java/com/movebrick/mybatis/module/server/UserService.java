package com.movebrick.mybatis.module.server;

import java.util.List;

import com.movebrick.mybatis.module.bean.User;

public interface UserService<ID> {
	
	String login(ID id);
	
	List<User> getList();
	
	/**
	 * 
	 * I am not responsible of this code.
	 * They made me write it, against my will.
	 *
	 * <p>Title: getAll</p> 
	 * <p>@author: Aaron
	 * <p>Description: </p>  
	 *	多对一查询
	 * @return
	 * 2019年3月19日 下午4:26:01  
	 * @version Copyright (c) 2018,GPDI  All Rights Reserved.
	 */
	List<User> getAll();
}
