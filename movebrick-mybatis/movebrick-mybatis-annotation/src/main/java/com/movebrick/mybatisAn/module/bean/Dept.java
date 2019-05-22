package com.movebrick.mybatisAn.module.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

    private Integer did;
    private String dname;
}
