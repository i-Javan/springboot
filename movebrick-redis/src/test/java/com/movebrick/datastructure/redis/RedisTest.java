package com.movebrick.datastructure.redis;

import javax.annotation.Resource;

import com.movebrick.jdbcTemplate.modul.dao.BaseDao;
import com.movebrick.redis.Application;
import com.movebrick.redis.module.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Resource
    private RedisUtils redisUtils;

//    @Autowired
//    RedisDao redisDao;

    @Autowired
    BaseDao baseDao;
    
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        String string = redisUtils.get("a");
        System.out.println(string);
    }

    @Test
    public void getList(){
        List<Map<String,Object>> list = baseDao.getList("select * from dept");
        for (Map map : list){
            System.err.println(map);
        }
    }
}
