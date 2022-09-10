package com.example.microdemouserservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microdemouserservice.entity.User;
import com.example.microdemouserservice.service.UserService;
import com.example.microdemouserservice.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		LOGGER.info("Inside UserController saveUser...");
		return service.saveUser(user);
	}
	
	/*@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long userId) {
		LOGGER.info("Inside UserController getUserById...");
		return service.getUserById(userId);
	}*/
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		LOGGER.info("Inside UserController getUserWithDepartment...");
		return service.getUserWithDepartment(userId);
	}
}
