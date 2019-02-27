package com.movebrick.dubbo.module.bean;

import lombok.Data;

@Data
public class User {
	private String id;
	private String name;
	private String age;
	private String email;
	public User(String id, String name, String age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	
}
