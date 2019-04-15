package com.movebrick.datastructure.mybatis.module.mapper;

import java.util.List;

import com.movebrick.datastructure.mybatis.module.bean.User;

public interface UserMapper{
	
	/**
	 * 
	 * I am not responsible of this code.
	 * They made me write it, against my will.
	 *
	 * <p>Title: getList</p> 
	 * <p>@author: Aaron
	 * <p>Description: </p>  
	 *	简单查询
	 * @return
	 * 2019年3月19日 下午4:25:44  
	 * @version Copyright (c) 2018,GPDI  All Rights Reserved.
	 */
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
