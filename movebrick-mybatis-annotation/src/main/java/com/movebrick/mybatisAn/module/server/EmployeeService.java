package com.movebrick.mybatisAn.module.server;

import com.movebrick.mybatisAn.module.bean.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getList();

    /**
     * 清除缓存
     * @param CacheKey
     */
    void clearCache(String CacheKey);
}
