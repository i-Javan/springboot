package com.movebrick.datastructure.activeMQ.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/activemq")
public class ActiveMQController {
	// 注入jsmtemplate
		@Autowired
		private JmsMessagingTemplate jmsMessagingTemplate;
		
		@Autowired
		private Queue queue;

		@Autowired
		private Topic topic;

		@RequestMapping("/sendMsg")
		public void sendMsg(String msg) {
			jmsMessagingTemplate.convertAndSend("my_msg", msg);
			System.out.println("my_msg发送成功");
		}

		@RequestMapping("/sendMap")
		public void sendMap() {
			Map<String, String> map = new HashMap<String, String>();
	        map.put("mobile", "13888888888");
	        map.put("content", "王总喜提兰博基尼");
	        jmsMessagingTemplate.convertAndSend("my_map", map);
	        System.out.println("map发送成功");
		}
		
		@RequestMapping("/sendMsgQueue")
		public void sendMsgQueue(String msg) {
			this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
			System.out.println("Queue发送成功");
		}
		
		@RequestMapping("/sendMsgTopic")
		public void sendMsgTopic(String msg) {
			this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
			System.out.println("Topic发送成功");
		}
}
