package com.movebrick.datastructure.mybatisAn.module.server.impl;

import com.movebrick.datastructure.mybatisAn.module.bean.Employee;
import com.movebrick.datastructure.mybatisAn.module.mapper.EmployeeMapper;
import com.movebrick.datastructure.mybatisAn.module.server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@CacheConfig(cacheNames = "common")
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    @Cacheable(key="'getList'")
    public List<Employee> getList() {
        return employeeMapper.findAll();
    }

    @CacheEvict(key = "'getList'")
    public void clearCache(String CacheKey) { }
}
