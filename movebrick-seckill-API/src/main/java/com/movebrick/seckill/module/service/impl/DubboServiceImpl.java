package com.movebrick.seckill.module.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.movebrick.seckill.module.bean.User;
import com.movebrick.seckill.module.service.DubboService;

import java.util.Arrays;
import java.util.List;

@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {

    public List<User> getList() {
        return Arrays.asList(new User[]{new User("1", "小红", "18", "18@qq.com"), new User("1", "❤", "17", "17@qq.com")});
    }

    public User getById(String id) {
        return new User("1", "小红", "18", "18@qq.com");
    }

}
