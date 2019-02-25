package com.movebrick.module.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.framework.base.contorller.BaseContorller;
import com.movebrick.module.bean.User;
import com.movebrick.module.service.UserService;

@RestController
@RequestMapping("/pc/mybatis")
public class MybatisPlusController extends BaseContorller<User,String>{
	@Autowired
	private UserService<String> userService;
	
	@GetMapping("/get")
	public List<User> get(){
		return userService.getList();
	}
}
