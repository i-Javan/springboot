package com.movebrick.framework.base.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.movebrick.framework.base.service.BaseService;

public abstract class BaseContorller<T,ID> {
	
	@Autowired
	private BaseService<T, ID> baseService;
	
	@GetMapping("getById")
	public T get(ID id){
		T t = null;
		return t;
	}
	
	@GetMapping("getList")
	public List<T> getList(){
		return baseService.getList();
	}
}
 