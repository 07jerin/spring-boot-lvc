package com.jerin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstEndPoint {
	

	@RequestMapping("/mypage")
	public String myString() {
		
		return "Welocome to mypage ";
	}

	@RequestMapping("/second")
	public String sayHello(@RequestParam String name, @RequestParam String job) {
		return "Welcome " + name + " : " + job;
	}

	@RequestMapping(path = "secondpathvar/{name}")
	public String sayHello2(@PathVariable String name) {
		return "Welcome " + name;
	}
	
	
	@GetMapping(path="secondbeanssample")
	public SecondSampleBean sayHiFromSecondBean() {
		return new SecondSampleBean("From second sample bean");
	}

}
