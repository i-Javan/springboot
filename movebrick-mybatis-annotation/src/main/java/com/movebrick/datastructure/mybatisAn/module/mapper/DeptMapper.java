package com.movebrick.datastructure.mybatisAn.module.mapper;

import com.movebrick.datastructure.mybatisAn.module.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {
    //班级带出学生
    @Select("select * from dept where did=#{0}")
    Dept getDeptById(Integer did);

}
