package com.movebrick.mybatis.module.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movebrick.mybatis.module.bean.Dept;
import com.movebrick.mybatis.module.mapper.DeptMapper;
import com.movebrick.mybatis.module.server.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired 
	private DeptMapper deptMapper;
	
	@Override
	public Dept get(Integer id) {
		return deptMapper.get(id);
	}
	
}
