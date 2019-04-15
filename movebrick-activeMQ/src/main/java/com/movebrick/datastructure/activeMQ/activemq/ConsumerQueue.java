package com.movebrick.datastructure.activeMQ.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * queue模式
 * @author MMJ
 *
 */
@Component
public class ConsumerQueue {
	/*
	 * 监听和读取消息
	 */
	@JmsListener(destination = "active.queue")
	public void readActiveQueue(String message) {
		System.out.println("queue接到：" + message);
		// TODO something

	}
}