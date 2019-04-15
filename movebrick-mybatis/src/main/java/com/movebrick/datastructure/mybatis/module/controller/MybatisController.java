package com.movebrick.datastructure.mybatis.module.controller;

import java.util.List;

import com.movebrick.datastructure.mybatis.module.server.DeptService;
import com.movebrick.datastructure.mybatis.module.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.datastructure.mybatis.generator.mapper.TCompanyinfoMapper;
import com.movebrick.datastructure.mybatis.generator.model.TCompanyinfoExample;
import com.movebrick.datastructure.mybatis.generator.model.TCompanyinfoExample.Criteria;
import com.movebrick.datastructure.mybatis.module.bean.Dept;
import com.movebrick.datastructure.mybatis.module.bean.User;


@RestController
@RequestMapping("/pc/mybatis")
public class MybatisController{
	@Autowired
	private UserService<String> userService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private TCompanyinfoMapper tcompanyinfoMapper; 
	
	@GetMapping("/user/get")
	public List<User> get(){
		List<User> list = userService.getList();
		System.out.println("输出："+list.get(0).getDept());
		return list;
	}
	
	@GetMapping("/user/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/dept/getdept")
	public Dept getDept(){
		return deptService.get(1);
	}
	
	@GetMapping("/t/get")
	public Object TgetDept(){
		TCompanyinfoExample example = new TCompanyinfoExample();
		Criteria criterua = example.createCriteria();
		criterua.andIdBetween(1000,1200);//查找id1-100之间
		return tcompanyinfoMapper.selectByExample(example);
	}
}
