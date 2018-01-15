package com.jimenezlav.activemq;

import static org.junit.Assert.assertTrue;

import javax.jms.JMSException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import com.jimenezlav.activemq.model.Email;
import com.jimenezlav.activemq.producer.Producer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootActivemqApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private Producer producer;

	@Test
	public void sendSimpleMessage() throws InterruptedException, JMSException {
		this.producer.send(new Email("jivel@developer.git","This a Test message"));
		Thread.sleep(1000L);
		log.info("{}",outputCapture.toString());
		assertTrue(this.outputCapture.toString().contains("y"));
	}

}
