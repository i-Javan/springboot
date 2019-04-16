package com.movebrick.jpa.module.dao;

import com.movebrick.jpa.module.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {

    //查询大于20岁的用户
    @Query(value = "select * from t_user where age > ?",nativeQuery = true)
    public List<User> getUserByAge(int age);
}
