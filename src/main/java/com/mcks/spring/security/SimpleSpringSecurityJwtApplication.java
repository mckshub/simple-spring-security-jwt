package com.mcks.spring.security;

import com.mcks.spring.security.entity.User;
import com.mcks.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringSecurityJwtApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringSecurityJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.getUsersList().add(new User("admin", "admin"));
		System.out.println("User Added sucessfully");
	}
}
