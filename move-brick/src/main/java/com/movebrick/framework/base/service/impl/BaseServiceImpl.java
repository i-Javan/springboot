package com.movebrick.framework.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movebrick.framework.base.mapper.BasicsMapper;
import com.movebrick.framework.base.service.BaseService;

@Service
public class BaseServiceImpl<T,ID> implements BaseService<T, ID>
{
	@Autowired
	private BasicsMapper<T, ID> baseMapper;
	
	public List<T> getList() {
		System.out.println(("----- selectAll method test ------"));
        List<T> selectList = baseMapper.getList();
		return selectList;
	}
}
