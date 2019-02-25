package com.movebrick.module.contorller.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

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