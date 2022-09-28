package com.sony.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sony.model.User;

@Service

public class UserManager {

	private Map<String, User> users;

	public UserManager() {
		users = new HashMap<>();
		User user;

		user = new User("Dhoni", "MS", "dhoni@dhoni", "ranchi");
		users.put(user.getId(), user);
		// System.out.println(users.values());
		user = new User("Yuvii", "S12", "Yuvii@Yuvii", "mohali");
		users.put(user.getId(), user);
		// System.out.println(users.values());
		user = new User("Rishabh", "Pant", "Rishabh@Rishabh", "uk");
		users.put(user.getId(), user);
		// System.out.println(users.values());
	}

	public Iterable<User> getAllUsers() {
		return this.users.values();
	}

	public User getUserById(String id) {
		return this.users.get(id);
	}

}
