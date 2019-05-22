package com.movebrick.datastructure.dubbo.module.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	/**
	 * @author Javan 
	 * 2019年3月26日 下午5:31:15
	 */
	private static final long serialVersionUID = 1L;
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
