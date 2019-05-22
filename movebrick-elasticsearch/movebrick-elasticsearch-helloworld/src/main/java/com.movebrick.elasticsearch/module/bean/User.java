package com.movebrick.elasticsearch.module.bean;

import java.io.Serializable;

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
	private String id;
	private String name;
	private String age;
	private String email;
}
