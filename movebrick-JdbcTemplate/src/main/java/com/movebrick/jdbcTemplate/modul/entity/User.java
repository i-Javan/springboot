package com.movebrick.jdbcTemplate.modul.entity;

import lombok.Data;

@Data
public class User {
    Integer id;
    String name;
    String age;
    String email;
    Dept dept;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
