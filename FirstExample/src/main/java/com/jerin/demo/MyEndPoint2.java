package com.jerin.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndPoint2 {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAll() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return service.findOne(id);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return service.save(user);
	}
}
