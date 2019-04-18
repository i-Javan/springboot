package com.movebrick.jdbctemplate;

import com.movebrick.jdbcTemplate.Application;
import com.movebrick.jdbcTemplate.modul.dao.BaseDao;
import com.movebrick.jdbcTemplate.modul.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Get {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BaseDao baseDao;

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

    @Test
    public void getBaseDaoList(){
        List<Map<String,Object>> list = baseDao.getList("select * from dept");
        for (Map map : list){
            System.err.println(map);
        }
    }


}
