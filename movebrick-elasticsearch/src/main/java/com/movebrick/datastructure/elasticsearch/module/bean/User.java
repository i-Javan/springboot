package com.movebrick.datastructure.elasticsearch.module.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "blog",type = "user")
public class User implements Serializable{
	/**
	 * @author Aaron 
	 * 2019年3月1日 上午10:09:10
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String age;
	private String email;

	public User(int id, String name, String age, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public User(){

	}
}
