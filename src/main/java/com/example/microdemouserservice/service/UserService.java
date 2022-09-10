package com.example.microdemouserservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.example.microdemouserservice.entity.User;
import com.example.microdemouserservice.repo.UserRepo;
import com.example.microdemouserservice.vo.Department;
import com.example.microdemouserservice.vo.ResponseTemplateVO;

@Service
public class UserService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo repo;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public User saveUser(@RequestBody User user) {
		LOGGER.info("Inside UserService saveUser...");
		return repo.save(user);
	}
	
	//not being used
	public User getUserById(@PathVariable("id") Long userId) {
		LOGGER.info("Inside UserService getUserById...");
		return repo.findById(userId).get();
	}
	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		LOGGER.info("Inside UserController getUserWithDepartment...");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		
		User user = repo.findById(userId).get();
		Department department = restTemplate.getForObject("http://localhost:8082/departments/" + user.getDeparmentId(), Department.class);
		
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}
}
