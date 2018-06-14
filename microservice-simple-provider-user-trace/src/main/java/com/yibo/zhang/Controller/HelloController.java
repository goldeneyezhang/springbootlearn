package com.yibo.zhang.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yibo.zhang.DAO.UserRepository;

@RestController
public class HelloController {


	@GetMapping("/hello")
	public String Hello() {
		return "Hello World";
	}
}
