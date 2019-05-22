package com.movebrick.mybatisAn.module.controller;

import com.movebrick.mybatisAn.module.bean.Dept;
import com.movebrick.mybatisAn.module.bean.Employee;
import com.movebrick.mybatisAn.module.server.DeptService;
import com.movebrick.mybatisAn.module.server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pc/mybatisan/cache")
public class CacheController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @GetMapping("clearCache")
    public boolean clearCache(String key){
        employeeService.clearCache(key);
        return true;
    }

    @GetMapping("getDeptById")
    public Dept getDeptById(Integer id){
        Dept dept = deptService.getDeptById(id);
        return dept;
    }

    @GetMapping("/getList")
    public List<Employee> getList(){
        return employeeService.getList();
    }

}
