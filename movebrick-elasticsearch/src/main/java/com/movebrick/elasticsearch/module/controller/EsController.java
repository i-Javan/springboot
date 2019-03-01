package com.movebrick.elasticsearch.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.elasticsearch.module.bean.User;
import com.movebrick.elasticsearch.module.repository.UserRepository;


@RestController
@RequestMapping("/pc/es")
public class EsController{
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/getList")
	public Object get(){
		return userRepository.findAll();
	}
	
	/*@GetMapping("/getByKey")
	public Object getByKey(){
		return userRepository
	}*/
	
	@GetMapping("/save")
	public Object save(User user){
		return userRepository.save(user);
	}
}
