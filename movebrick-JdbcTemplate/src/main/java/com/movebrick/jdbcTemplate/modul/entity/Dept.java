package com.movebrick.jdbcTemplate.modul.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    Integer id;
    String Dname;
    List<User> listUser;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }
}
