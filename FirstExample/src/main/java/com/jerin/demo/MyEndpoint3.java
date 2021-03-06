package com.jerin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndpoint3 {

	
	@Autowired
	ExampleProperties props;
	
	
	@RequestMapping("/greetothers")
	public String greet(@RequestParam String details) {
		return props.getGreeting() + " : " + details;
	}
}
 