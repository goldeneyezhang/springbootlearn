package com.yibo.application.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import configuration.*;
import feign.Param;
import feign.RequestLine;

import com.yibo.application.model.User;
@FeignClient(name="microservice-provider-user",configuration=FeignConfiguration.class,fallback = FeignClientFallback.class)
public interface UserFeignClient {
	@RequestLine("GET /{id}")
	public User findById(@Param("id") Integer id);
}
