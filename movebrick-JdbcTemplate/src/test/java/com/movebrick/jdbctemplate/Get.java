package com.movebrick.jdbctemplate;

import com.movebrick.jdbcTemplate.Application;
import com.movebrick.jdbcTemplate.modul.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Get {
    @Autowired
    UserRepository userRepository;

    @Test
    public void getList(){
        List<?> list = userRepository.getList();
        System.err.println(list);
    }

    @Test
    public void getAll(){
        List<?> list = userRepository.getAll();
        System.err.println(list);
    }

    @Test
    public void getUserList(){
        List<?> list = userRepository.getUserList();
        System.err.println(list);
    }


}
