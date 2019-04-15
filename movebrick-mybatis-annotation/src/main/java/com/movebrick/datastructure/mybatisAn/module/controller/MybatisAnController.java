package com.movebrick.datastructure.mybatisAn.module.controller;

import java.util.List;

import com.movebrick.datastructure.mybatisAn.module.bean.User;
import com.movebrick.datastructure.mybatisAn.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/mybatisan")
public class MybatisAnController{
	@Autowired
	private UserService<String> userService;
	
	@GetMapping("/get")
	public List<User> get(){
		return userService.getList();
	}
	
	@GetMapping("/t")
	public String t(){
		return "t";
	}
}
