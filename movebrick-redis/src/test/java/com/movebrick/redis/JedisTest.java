package com.movebrick.redis;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {

    @Test
    //最简单和基础的调用方式，
    public void openJedis() {
        System.out.println(("----- 最简单和基础的调用方式  ------"));
        Jedis jedis = new Jedis("172.16.88.49");
        jedis.auth("123456");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            jedis.set("n" + i, "n" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
        jedis.close();
        //很简单吧，每次set之后都可以返回结果，标记是否成功。
    }
    
    @Test
    //事务方式(Transactions)
    public void openJedisTransactions() {
        System.out.println(("----- 事务方式  ------"));
        Jedis jedis = new Jedis("172.16.88.49");
        jedis.auth("123456");
        long start = System.currentTimeMillis();
        Transaction tx = jedis.multi();
        for (int i = 0; i < 10; i++) {
        	 tx.set("t" + i, "t" + i);
        }
        @SuppressWarnings("unused")
		List<Object> results = tx.exec();
        long end = System.currentTimeMillis();
        System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
        jedis.close();
        //我们调用jedis.watch(…)方法来监控key，如果调用后key值发生变化，则整个事务会执行失败。另外，事务中某个操作失败，并不会回滚其他操作。这一点需要注意。还有，我们可以使用discard()方法来取消事务。
    }
    
    @Test
    //管道(Pipelining)
    public void openJedisPipelining() {
        System.out.println(("----- 管道  ------"));
        Jedis jedis = new Jedis("172.16.88.49");
        jedis.auth("123456");
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            pipeline.set("p" + i, "p" + i);
        }
        @SuppressWarnings("unused")
		List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
        jedis.close();
        //有时，我们需要采用异步方式，一次发送多个指令，不同步等待其返回结果。这样可以取得非常好的执行效率。这就是管道，调用方法如下：
      }
    
    @Test
    //管道中调用事务
    public void openJedisPipeliningTransactions() {
        System.out.println(("----- 管道中调用事务  ------"));
        Jedis jedis = new Jedis("172.16.88.49");
        jedis.auth("123456");
        long start = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        pipeline.multi();
        for (int i = 0; i < 10; i++) {
            pipeline.set("" + i, "" + i);
        }
        pipeline.exec();
        @SuppressWarnings("unused")
		List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined transaction: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
        jedis.close();
        //但是经测试（见本文后续部分），发现其效率和单独使用事务差不多，甚至还略微差点。
      }
    
    
}
