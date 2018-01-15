package com.jimenezlav.activemq.producer;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.jimenezlav.activemq.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
//	@Autowired
//	private JmsTemplate jmsTemplate;
	  

	@Autowired
	private Queue queue;

	@Override
	public void run(String... args) throws Exception {
		send(new Email("jivel@developer.git","Hello Jivel"));
		log.info("Message was sent to the Queue");
	}

	public void send(Email email) {
//		this.jmsMessagingTemplate.setDeliveryDelay(60000);
		this.jmsMessagingTemplate.convertAndSend(this.queue, email);
	}

}