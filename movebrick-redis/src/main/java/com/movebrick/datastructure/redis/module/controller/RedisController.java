package com.movebrick.datastructure.redis.module.controller;

import com.movebrick.datastructure.redis.module.redis.RedisUtils;
import com.movebrick.datastructure.redis.module.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/redis")
public class RedisController {

	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private RedisService redisService;
	
	@GetMapping("get")
	public String get(){
		return redisUtils.get("a");
	}
	
	@GetMapping("getList")
	public Object getList(){
		return redisService.getList("啊哈哈");
	}
}
