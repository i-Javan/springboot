package com.movebrick.datastructure.mybatis.module.server.impl;

import com.movebrick.datastructure.mybatis.module.mapper.DeptMapper;
import com.movebrick.datastructure.mybatis.module.server.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movebrick.datastructure.mybatis.module.bean.Dept;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired 
	private DeptMapper deptMapper;
	
	@Override
	public Dept get(Integer id) {
		return deptMapper.get(id);
	}
	
}
