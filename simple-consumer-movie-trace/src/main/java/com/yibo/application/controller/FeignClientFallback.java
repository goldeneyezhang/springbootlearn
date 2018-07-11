package com.yibo.application.controller;

import org.springframework.stereotype.Component;

import com.yibo.application.model.User;

@Component
 class FeignClientFallback implements UserFeignClient {
	
	public User findById(Integer id) {
		User user = new User();
		user.setId(-1);
		user.setUsername("默认用户2");
		return user;
	}
}
