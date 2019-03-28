package com.movebrick.redis.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.redis.module.redis.RedisUtils;
import com.movebrick.redis.module.service.RedisService;

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
