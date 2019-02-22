package com.movebrick.activeMQ.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * topic模式
 * @author MMJ
 *
 */
@Component
public class ConsumerTopic {
	/*
	 * 监听和读取消息
	 */
	@JmsListener(destination="active.topic")
	public void readActiveTopic(String message) {
		System.out.println("topic接收到：" + message);
		//TODO something
	}
	
	@JmsListener(destination="active.topic")
	public void readActiveTopic1(String message) {
		System.out.println("topic1接收到：" + message);
		//TODO something
	}

}