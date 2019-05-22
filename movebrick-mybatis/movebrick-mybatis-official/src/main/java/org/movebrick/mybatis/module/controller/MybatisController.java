package org.movebrick.mybatis.module.controller;

import java.util.List;

import org.movebrick.mybatis.module.bean.User;
import org.movebrick.mybatis.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pc/mybatis")
public class MybatisController{
	@Autowired
	private UserService<String> userService;
	
	@GetMapping("/get")
	public List<User> get(){
		return userService.getList();
	}
}
