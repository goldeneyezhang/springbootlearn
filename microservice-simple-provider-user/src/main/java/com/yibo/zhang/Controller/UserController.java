package com.yibo.zhang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yibo.zhang.DAO.UserRepository;
import com.yibo.zhang.Model.User;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User FindUser(@PathVariable Integer id) {
		User findOne=userRepository.findOne(id);
		return findOne;
	}
	@GetMapping("/all")
	public List<User> FindUser() {
		List<User> all=userRepository.findAll();
		return all;
	}
}
