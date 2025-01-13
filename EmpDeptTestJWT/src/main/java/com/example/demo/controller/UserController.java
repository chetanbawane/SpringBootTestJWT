package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
	
	@PostMapping("/saveUser")
	public User SaveUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.saveUser(user);
	}
	
//	@PostMapping("/login")
//	public String login(@RequestBody User user) {
//		return userService.verify(user);
//	}
}
