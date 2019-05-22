package com.movebrick.mybatisAn.module.mapper;

import com.movebrick.mybatisAn.module.bean.Dept;
import com.movebrick.mybatisAn.module.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

	@Select("SELECT * FROM employee WHERE ID = #{id}")
    Employee findUserById(@Param("id") String id);

    @Results({
    	@Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "email", column = "email"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "phone", column = "phone"),
        @Result(property = "did", column = "did"),
		@Result(
				property = "dept",
				javaType = Dept.class,
				column = "did",
				one = @One(
						select = "com.movebrick.mybatisAn.module.mapper.DeptMapper.getDeptById"
				)
		)
	})
	@Select("SELECT * FROM employee e left join dept d on e.did = d.did")
    List<Employee> findAll();
}
