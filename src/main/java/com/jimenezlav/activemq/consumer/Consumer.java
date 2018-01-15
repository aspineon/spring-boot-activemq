package com.jimenezlav.activemq.consumer;

import java.time.Instant;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jimenezlav.activemq.model.Email;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {

	@JmsListener(destination = "event.error")
	public void receiveQueue(Email email) throws Exception {
		log.info("Mensaje {} hora: {}",email, Instant.now());
	}

}