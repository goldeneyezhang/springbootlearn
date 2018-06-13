package com.yibo.microservice_config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class ConfigClientController {
	 @Value("${profile}")
	 private String profile;
	 @Value("${config}")
	 private String config;

  @GetMapping("/profile")
  public String hello() {
    return this.profile+","+this.config;
  }
}
