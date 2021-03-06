package com.jerin.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	public UserDaoService() {
		// TODO Auto-generated constructor stub
	}

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	static {
		users.add(new User(1, "Rame", new Date()));
		users.add(new User(2, "Raj", new Date()));
		users.add(new User(3, "Kevin", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		Optional<User> user = users.stream().filter(u -> u.getId() == id).findAny();

		return user.isPresent() ? user.get() : null;
	}

}
