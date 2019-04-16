package com.movebrick.jpa.module.entity;

import lombok.Data;

import java.util.List;

@Data
public class Dept {
    Integer id;
    String Dname;
    List<User> listUser;
}
