package com.movebrick.mybatisAn.module.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.movebrick.mybatisAn.module.bean.User;

@Mapper
public interface UserMapper{
	
	//private String id;
	//private String name;
	//private String age;
	//private String email;
	
	@Select("SELECT * FROM user WHERE ID = #{id}")
    User findUserById(@Param("id") String id);

    @Insert("INSERT INTO USER(ID,NAME,AGE,EMAIL) VALUES(#{id}, #{name}, #{age},#{email})")
    int insert(@Param("id") String id, @Param("name") String name, @Param("age") String age,@Param("email")String email);
    
    @Results({
    	@Result(property = "id", column = "ID"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "age", column = "AGE"),
        @Result(property = "email", column = "EMAIL")
	})
	@Select("SELECT ID,NAME,AGE,EMAIL FROM user")
    List<User> findAll();
    
    /*@Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(" +
            "#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insertByUser(User user);

    @Update("UPDATE T_USER SET NAME = #{name}, PASSWORD = #{password} WHERE PHONE = #{phone}")
    void update(User user);

    @Delete("DELETE FROM T_USER WHERE ID = #{id}")
    void delete(Integer id);*/

    
}
