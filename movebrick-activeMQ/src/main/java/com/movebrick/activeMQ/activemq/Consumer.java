package com.movebrick.activeMQ.activemq;


import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author MMJ
 *
 */
@Component
public class Consumer {
    @JmsListener(destination = "my_msg")
    public void readMsg(String text) {
        System.out.println("my_map接收到消息：" + text);
    }

    @JmsListener(destination = "my_map")
    public void readMap(Map<?, ?> map) {
        System.out.println("my_map接收到消息：" +map);
    }
}