package com.movebrick.dubbo.module.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	/**
	 * @author Aaron 
	 * 2019年2月27日 下午4:19:32
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String age;
	private String email;
}
