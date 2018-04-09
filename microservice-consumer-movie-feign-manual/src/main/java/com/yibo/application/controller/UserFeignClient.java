package com.yibo.application.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yibo.application.configuration.FeignLogConfiguration;
import com.yibo.application.model.User;

import feign.Param;
import feign.RequestLine;
@FeignClient(name="microservice-provider-user",configuration=FeignLogConfiguration.class)
public interface UserFeignClient {
	@RequestLine("GET /{id}")
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Integer id);
}
