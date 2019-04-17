package com.movebrick.datastructure.mybatisAn.module.server.impl;

import com.movebrick.datastructure.mybatisAn.module.bean.Dept;
import com.movebrick.datastructure.mybatisAn.module.mapper.DeptMapper;
import com.movebrick.datastructure.mybatisAn.module.server.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    @Cacheable(value = "getDeptById",key = "#id")
    public Dept getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }
}
