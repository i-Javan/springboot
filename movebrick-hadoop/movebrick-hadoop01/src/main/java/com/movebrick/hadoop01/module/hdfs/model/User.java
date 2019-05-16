package com.movebrick.hadoop01.module.hdfs.model;

import lombok.Data;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 类或方法的功能描述 : 用户实体类
 *
 * @author: logan.zou
 * @date: 2018-12-05 15:11
 */
@Data
public class User implements Writable {
    private String username;
    private Integer age;
    private String address;

    public User() {
    }

    public User(String username, Integer age, String address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }

    @Override
    public void write(DataOutput output) throws IOException {
        // 把对象序列化
        output.writeChars(username);
        output.writeInt(age);
        output.writeChars(address);
    }

    @Override
    public void readFields(DataInput input) throws IOException {
        // 把序列化的对象读取到内存中
        username = input.readUTF();
        age = input.readInt();
        address = input.readUTF();
    }
}

