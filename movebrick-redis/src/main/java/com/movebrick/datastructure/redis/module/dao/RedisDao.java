package com.movebrick.datastructure.redis.module.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisDao {

    public List<?> getList(String key){
        List<String> list = new ArrayList<>();
        list.add(key);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        return list;
    }
}
