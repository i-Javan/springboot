package com.movebrick.datastructure.redis.module.service;

import java.util.List;

public interface RedisService {
	/**
	 * 
	 * I am not responsible of this code.
	 * They made me write it, against my will.
	 *
	 * <p>Title: getList</p> 
	 * <p>@author: Javen
	 * <p>Description: </p>  
	 *	存入Redis数据库
	 * @param key
	 * @return
	 * 2019年3月18日 上午11:20:04  
	 * @version Copyright (c) 2018,GPDI  All Rights Reserved.
	 */
	List<?> getList(String key);

//	Object get(String key);
}
