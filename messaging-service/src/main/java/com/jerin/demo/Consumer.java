package com.jerin.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	
	@JmsListener(destination="sample.queue")
	public void recieveQueueMessage (String text) {
		System.out.println("Output \n ");
		System.out.println(text);
	}

}
