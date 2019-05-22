package com.movebrick.elasticsearch.module.bean;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "blog", type = "employee")
public class Employee implements Serializable {
    /**
     * @author Aaron
     * 2019年3月1日 上午10:09:10
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String email;
    private String phone;
    private Integer did;
}
