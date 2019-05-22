package com.movebrick.datastructure.mybatis.module.bean;

import java.util.List;

import lombok.Data;

@Data
public class Dept {
	private Integer id;
	private String dname;
	private List<User> userList;
}
