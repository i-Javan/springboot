package com.movebrick.datastructure.redis.module.service.impl;

import java.util.List;

import com.movebrick.datastructure.redis.module.dao.RedisDao;
import com.movebrick.datastructure.redis.module.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig()
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisDao redisDao;

	//@Autowired
	//private DeptService deptService;
	/**
	 * 存库
	 */
	@Override
	@Cacheable(value = "movebrick-redis",key = "#key")
	public List<?> getList(String key) {
		List<?> list = redisDao.getList(key);
		return list;
	}

//	/**
//	 * 存库
//	 */
//	@Cacheable(value = "get",key = "#key")
//	public Object get(String key) {
//		Dept dept = deptService.getDeptById(1);
//		return dept;
//	}
}
