package com.user.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.auth.dao.UserRepository;
import com.user.auth.model.User;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	List<User> list = new ArrayList<>();


	public List<User> getAllUser() {
		List<User> list = (List<User>) this.userRepository.findAll();
		return list;
	}

 
	public User getUserById(String username) {
		User user = null;
		// i use try block to check the status code
		try {
			
			user = this.userRepository.findByUsername(username);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User getUser(String Username) {
		return this.list.stream().filter((user)->user.getUsername().equals(Username)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}