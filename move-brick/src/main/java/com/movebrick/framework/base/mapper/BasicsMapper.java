package com.movebrick.framework.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.movebrick.module.bean.User;

public interface BasicsMapper<T,ID> extends BaseMapper<T> {
	
//		default String getT(T t){
//			return t.getClass().getSimpleName();
//		}
//	
		@Select("SELECT * FROM user")
		List<T> getList();
		
		
//		/** 
//	     * 这个通常也是hibernate的取得子类class的方法
//	     */  
//	    public HibernateBaseDao() {  
//	        Type genType = getClass().getGenericSuperclass();  
//	        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
//	        entityClass = (Class) params[0];  
//	    }
//	    @Override  
//	    public T get(String id) {  
//	        try {  
//	            return entityClass.newInstance();  
//	        } catch (Exception e) {
//	            e.printStackTrace();  
//	        }  
//	        return null;  
//	    }  
	    
		
		

		// 推荐使用#{}取值，不要用${},因为存在注入的风险
		@Insert("INSERT INTO user(name,phone,create_time,age) VALUES(#{name}, #{phone}, #{createTime},#{age})")
		@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // keyProperty java对象的属性；keyColumn表示数据库的字段
		int insert(User user);
		
		@Select("SELECT * FROM user WHERE id = #{id}")
		@Results({ @Result(column = "create_time", property = "createTime") })
		User findById(Long id);

		@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
		void update(User user);

		@Delete("DELETE FROM user WHERE id =#{userId}")
		void delete(Long userId);
}
