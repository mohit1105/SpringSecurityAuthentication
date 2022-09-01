package com.user.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.user.auth.dao.UserRepository;
import com.user.auth.model.User;

@SpringBootApplication
public class UserAuthenticationSecurityApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user=new User();
		user.setEmail("hv49271@gmail.com");
		user.setUsername("harsh");
		user.setPassword(this.bCryptPasswordEncoder.encode("Harsh"));
		user.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user);
		
		User user1=new User();
		user1.setEmail("karan49271@gmail.com");
		user1.setUsername("karan");
		user1.setPassword(this.bCryptPasswordEncoder.encode("karan"));
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
	}

}
