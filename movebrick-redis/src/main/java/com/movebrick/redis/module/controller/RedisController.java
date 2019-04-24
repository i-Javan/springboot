package com.movebrick.redis.module.controller;

import com.movebrick.redis.module.redis.RedisUtils;
import com.movebrick.redis.module.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1.String:
 * * 添加 set key value
 * * 获取 get key
 * * 删除 del key(空为nil)
 * 2.List:
 * * 推入列表右边 rpush listkey listvalue
 * * 获取列表在指定范围上的所有值 lrange listkey
 * * 通过下标获取列表里的单个元素 lindex listkey 0(下标从0开始)
 * * 从列表的左端弹出一个值，并返回被弹出的元素的值 lpop listkey
 * 3.Set:
 * * 将给定元素添加到集合 sadd setkey setvalue
 * * 返回集合包含的所有元素 smeembers setkey
 * * 检查指定元素是否在于集合中 sismember setkey setvalue
 * * 检查指定元素是否在于集合中，那么移除这个元素 srem
 * 4.Haash:
 * * 在散列里面关联起指定的键值对 hset hashkey valuekey valuevalue
 * * 获取指定散列键的值 hget hashkey valuekey
 * * 获取散列包含的所有键值对 hgetall hashkey
 * * 删除键 hdel valuekey
 * 5.ZSet
 * * 将一个带有给定分值的成员添加到有序集合里面 zadd ZsetValue
 * * 根据元素在有序排列中所处的位置，从有序集合里面获取多个元素 zrange zsetkey startindex endindex
 * * 获取有序集合在给定分值范围内的所有元素 zrangebyscore zsetkey startindex endindex  (查询全部：zrangebyscore zsetkey -inf +inf) WITHSCORES
 * * 如果指定成员存在于有序集合中，那么移除这个成员 zrem
 */
@RestController
@RequestMapping("/pc/redis")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedisService redisService;

    @GetMapping("get")
    public String get() {
        return redisUtils.get("a");
    }

    @GetMapping("getList")
    public Object getList(String key) {
        return redisService.getList(key);
    }

//	@GetMapping("getDept")
//	public Object getDept(){
//		return redisService.get("a");
//	}

}
