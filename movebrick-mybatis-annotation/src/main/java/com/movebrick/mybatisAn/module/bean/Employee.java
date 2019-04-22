package com.movebrick.mybatisAn.module.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String email;
    private String phone;
    private Integer did;
    private Dept dept;
}
