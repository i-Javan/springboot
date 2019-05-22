package org.movebrick.mybatisPlus.module.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.movebrick.mybatisPlus.module.bean.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


public interface UserMapper extends BaseMapper<User>{
	// 推荐使用#{}取值，不要用${},因为存在注入的风险
	@Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // keyProperty java对象的属性；keyColumn表示数据库的字段
	int insert(User user);

	@Select("SELECT * FROM user")
	//@Results({ @Result(column = "create_time", property = "createTime")})
	List<User> getList();

	@Select("SELECT * FROM user WHERE id = #{id}") 
	@Results({ @Result(column = "create_time", property = "createTime") })
	User findById(Long id);

	@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{userId}")
	void delete(Long userId);
}
