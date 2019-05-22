package com.movebrick.seckill.module.service;

import com.movebrick.seckill.module.bean.User;

import java.util.List;

public interface DubboService {

    List<User> getList();

    User getById(String id);

}
