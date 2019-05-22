package com.movebrick.seckill.module.mapper;

import com.movebrick.seckill.module.bean.StockOrder;

public interface StockOrderMapper {

    int insertSelective(StockOrder stockOrder);
}
