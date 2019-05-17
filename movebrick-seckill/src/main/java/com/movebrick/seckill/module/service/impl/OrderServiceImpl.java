package com.movebrick.seckill.module.service.impl;

import com.movebrick.seckill.module.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    //@Resource(name = "DBOrderService")
    //private com.crossoverJie.seconds.kill.service.OrderService orderService;

    @Override
    public int createWrongOrder(int sid) {
        return 0;
    }
}
