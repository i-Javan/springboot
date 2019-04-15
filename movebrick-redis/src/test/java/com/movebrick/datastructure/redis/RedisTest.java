package com.movebrick.datastructure.redis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.movebrick.datastructure.redis.module.redis.RedisUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtils redisUtils;
    
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        String string = redisUtils.get("a");
        System.out.println(string);
    }
}
