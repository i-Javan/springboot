package com.movebrick.jdbcTemplate.modul.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getList(String sql){
        List<Map<String, Object>> list = jdbcTemplate.query(sql, new ColumnMapRowMapper());
        return list;
    }

}
