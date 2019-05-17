package com.movebrick.seckill.module.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.movebrick.seckill.module.service.OrderService;
import com.movebrick.seckill.module.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 令牌桶算法
 * 原理是系统会以一个恒定的速度往桶里放入令牌，而如果请求需要被处理，则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。 当桶满时，新添加的令牌被丢弃或拒绝。
 */
@RestController
@RequestMapping("/pc/seckill")
public class SeckillController {

    @Autowired
    private StockService stockService;
    @Autowired
    private OrderService orderService;

    private static Logger logger = LoggerFactory.getLogger(SeckillController.class);


    private static RateLimiter limiter = RateLimiter.create(1);
    private static int i = 0;

    @GetMapping("play")
    public String exec() {
        //System.err.println("请求次数：" + i + ":" + limiter.tryAcquire());
        i++;
        limiter.acquire(1);
        try {
            // 处理核心逻辑
            //TimeUnit.SECONDS.sleep(5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "--" + System.currentTimeMillis() / 1000;
    }

    @RequestMapping("/createWrongOrder/{sid}")
    @ResponseBody
    public String createWrongOrder(@PathVariable int sid) {
        logger.info("sid=[{}]", sid);
        int id = 0;
        try {
            id = orderService.createWrongOrder(sid);
        } catch (Exception e) {
            logger.error("Exception", e);
        }
        return String.valueOf(id);
    }
}

/**
 * 修饰符和类型 方法和描述
 * double  acquire()
 * 从RateLimiter获取一个许可，该方法会被阻塞直到获取到请求
 * double acquire(int permits)
 * 从RateLimiter获取指定许可数，该方法会被阻塞直到获取到请求
 * static RateLimiter create(double permitsPerSecond)
 * 根据指定的稳定吞吐率创建RateLimiter，这里的吞吐率是指每秒多少许可数（通常是指QPS，每秒多少查询）
 * static RateLimiter create(double permitsPerSecond, long warmupPeriod, TimeUnit unit)
 * 根据指定的稳定吞吐率和预热期来创建RateLimiter，这里的吞吐率是指每秒多少许可数（通常是指QPS，每秒多少个请求量），在这段预热时间内，RateLimiter每秒分配的许可数会平稳地增长直到预热期结束时达到其最大速率。（只要存在足够请求数来使其饱和）
 * double getRate()
 * 返回RateLimiter 配置中的稳定速率，该速率单位是每秒多少许可数
 * void setRate(double permitsPerSecond)
 * 更新RateLimite的稳定速率，参数permitsPerSecond 由构造RateLimiter的工厂方法提供。
 * String toString()
 * 返回对象的字符表现形式
 * boolean tryAcquire()从RateLimiter
 * 获取许可，如果该许可可以在无延迟下的情况下立即获取得到的话
 * boolean tryAcquire(int permits)从RateLimiter
 * 获取许可数，如果该许可数可以在无延迟下的情况下立即获取得到的话
 * boolean tryAcquire(int permits, long timeout, TimeUnit unit)从RateLimiter
 * 获取指定许可数如果该许可数可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout 过期之前获取得到许可数的话，那么立即返回false （无需等待）
 * boolean tryAcquire(long timeout, TimeUnit unit)从RateLimiter
 * 获取许可如果该许可可以在不超过timeout的时间内获取得到的话，或者如果无法在timeout 过期之前获取得到许可的话，那么立即返回false（无需等待）
 */

