package com.movebrick.seckill.module.service;

import com.movebrick.seckill.module.bean.Stock;

public interface StockService {

    Stock getStockById(int sid);

    int updateStockById(Stock stock);

}
