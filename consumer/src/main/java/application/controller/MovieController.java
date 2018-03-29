package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import application.model.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.userServiceUrl}")
	private String userServiceUrl;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Integer id) {
		System.out.println(userServiceUrl);
		return this.restTemplate.getForObject(userServiceUrl+id, User.class);
	}
}
