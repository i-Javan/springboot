package org.movebrick.mybatisPlus.module.controller;

import java.util.List;

import org.movebrick.mybatisPlus.module.bean.User;
import org.movebrick.mybatisPlus.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pc/mybatis")
public class MybatisPlusController{
	@Autowired
	private UserService<String> userService;
	
	@GetMapping("/get")
	public List<User> get(){
		return userService.getList();
	}
}
