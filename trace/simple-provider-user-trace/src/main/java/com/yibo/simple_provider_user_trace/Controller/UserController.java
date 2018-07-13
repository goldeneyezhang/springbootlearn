package com.yibo.simple_provider_user_trace.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yibo.simple_provider_user_trace.DAO.UserRepository;
import com.yibo.simple_provider_user_trace.Model.User;



@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Integer id) {
		User findOne=userRepository.findOne(id);
		return findOne;
	}
	@GetMapping("/all")
	public List<User> FindUser() {
		List<User> all=userRepository.findAll();
		return all;
	}
}
