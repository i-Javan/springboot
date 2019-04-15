package com.movebrick.jdbcTemplate.modul.dao;

import com.movebrick.jdbcTemplate.modul.entity.Dept;
import com.movebrick.jdbcTemplate.modul.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 普通查询
     * @return
     */
    public List<?> getList(){
        List<User> query = jdbcTemplate.query("select * from user", new UserRowMapper());
        return query;
    }

    /**
     * 行映射
     */
    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getString("age"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
    }


    /**
     * 普通查询
     * @return
     */
    public List<?> getUserList(){
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        List<User> query = jdbcTemplate.query("select * from user",rowMapper);
        return query;
    }


    /**
     * 关联查询
     * @return
     */
    public List<?> getAll(){
        List<User> query = jdbcTemplate.query("select u.*,d.id as did,d.dname from user u left join dept d on u.did = d.id;", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getString("age"));
                user.setEmail(rs.getString("email"));
                Dept dept = new Dept();
                dept.setId(rs.getInt("did"));
                dept.setDname(rs.getString("dname"));
                user.setDept(dept);
                return user;
            }
        });
        return query;
    }




}
