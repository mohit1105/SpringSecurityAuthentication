package com.user.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.auth.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUsername(String username);

}