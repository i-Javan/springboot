package com.movebrick.seckill.module.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.movebrick.seckill.module.bean.Stock;
import com.movebrick.seckill.module.bean.StockOrder;
import com.movebrick.seckill.module.mapper.StockOrderMapper;
import com.movebrick.seckill.module.service.DBOrderService;
import com.movebrick.seckill.module.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Service(version = "DBOrderService")
public class DBOrderServiceImpl implements DBOrderService {
    @Resource(name = "DBStockService")
    private StockService stockService;
    @Autowired
    private StockOrderMapper orderMapper;

    @Override
    public int createWrongOrder(int sid) throws Exception {
        //校验库存
        Stock stock = checkStock(sid);
        //扣库存
        saleStock(stock);
        //创建订单
        int id = createOrder(stock);
        return id;
    }

    private Stock checkStock(int sid) {
        Stock stock = stockService.getStockById(sid);
        if (stock.getSale().equals(stock.getCount())) {
            throw new RuntimeException("库存不足");
        }
        return stock;
    }

    private int saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1);
        return stockService.updateStockById(stock);
    }

    private int createOrder(Stock stock) {
        StockOrder order = new StockOrder();
        order.setSid(stock.getId());
        order.setName(stock.getName());
        int id = orderMapper.insertSelective(order);
        return id;
    }
}
