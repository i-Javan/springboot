package com.movebrick.jpa.module.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="T_USER")
public class User {
    @Id
    Integer id;
    @Column(length = 255)
    String name;
    @Column(length = 255)
    String age;
    @Column(length = 255)
    String email;

    //Dept dept;
}
