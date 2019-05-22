package com.movebrick.seckill.module.dao;

import com.movebrick.jdbcTemplate.modul.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisDao {

    @Autowired
    private BaseDao baseDao;

    public List<?> getList(String key) {
        List<String> list = new ArrayList<>();
        list.add(key);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        return list;
    }

    public List<?> getListBySql(String sql) {
        List<?> list = baseDao.getList(sql);
        return list;
    }
}
