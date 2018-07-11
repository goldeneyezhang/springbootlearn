package com.yibo.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yibo.application.model.User;

import feign.hystrix.FallbackFactory;
@Component
 class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
	private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);
	
	
	public UserFeignClient create(final Throwable cause) {
		return new UserFeignClient() {
			public User findById(Integer id) {
				FeignClientFallbackFactory.LOGGER.info("fallback; reason was:",cause);
				User user = new User();
				user.setId(-1);
				user.setUsername("默认用户KK");
				return user;
			}
		};
	}
}
