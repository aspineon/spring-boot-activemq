package com.jimenezlav.activemq.controller;

import java.time.Instant;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimenezlav.activemq.model.Email;
import com.jimenezlav.activemq.producer.Producer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private Producer producer;
	
	@PostMapping("/email")
	public ResponseEntity<Void> sendEmail(@Valid @RequestBody Email email) {
		producer.send(email);
		log.info("Send email: {}, hora de envio: {}", email, Instant.now());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
