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
@RequestMapping("/pc/user") 
public class UserController extends BaseContorller<User,Integer>{
	
	@Autowired
	private UserService<String> userService;
	
	//@Autowired
	//private BasicsMapper<User,Integer> baseMapper;
	//@Autowired
	//private BasicsMapper2 baseMapper2;
	
	//@Autowired
	//private BaseMapper<User> baseMapper3;
	
	@GetMapping("/hello")
	public String hello(){
		return "hello";   
	}
	
	@GetMapping("/get")
	public String get(){
		return "get";
	}
	
	@GetMapping("/getMybatisPlus")
	public Object getMybatisPlus(){
		//return baseMapper.selectList(null);
		return null;
	}
	
	//@GetMapping("/getMybatisPlus2")
	//public Object getMybatisPlus2(){
	//	return baseMapper3.selectList(null);
	//}

	@GetMapping("/getListMybatis")
	public List<User> getListMybatis(){
		return userService.getList();
	}
}
