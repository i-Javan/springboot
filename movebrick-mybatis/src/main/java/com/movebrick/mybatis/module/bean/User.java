package com.movebrick.mybatis.module.bean;

import lombok.Data;

@Data
public class User {
	private String id;
	private String name;
	private String age;
	private String email;
	private User user;
	private Integer did;
	private Dept dept;
}
