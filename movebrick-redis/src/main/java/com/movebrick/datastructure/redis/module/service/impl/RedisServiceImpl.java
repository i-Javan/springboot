package com.movebrick.datastructure.redis.module.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.movebrick.datastructure.redis.module.service.RedisService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

	/**
	 * 存库
	 */
	@Override
	@Cacheable(value = "movebrick-redis",key = "#key")
	public List<?> getList(String key) {
		List<String> list = new ArrayList<>();
		list.add(key);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		return list;
	}

}
