package com.movebrick.mybatisAn.module.controller;

import java.util.List;

import com.movebrick.mybatisAn.module.bean.Employee;
import com.movebrick.mybatisAn.module.bean.User;
import com.movebrick.mybatisAn.module.server.EmployeeService;
import com.movebrick.mybatisAn.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/mybatisan")
public class MybatisAnController{
	@Autowired
	private UserService<String> userService;
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/get")
	public List<User> get(){
		return userService.getList();
	}
	
	@GetMapping("/t")
	public String t(){
		return "t";
	}

	@GetMapping("/getList")
	public List<Employee> getList(){
		return employeeService.getList();
	}

}
